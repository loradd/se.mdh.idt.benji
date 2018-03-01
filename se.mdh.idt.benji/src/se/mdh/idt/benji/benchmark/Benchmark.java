package se.mdh.idt.benji.benchmark;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.Objectives;
import org.eclipse.viatra.dse.api.Solution;
import org.eclipse.viatra.dse.api.SolutionTrajectory;
import org.eclipse.viatra.dse.api.Strategies;
import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.solutionstore.SolutionStore;
import org.eclipse.viatra.dse.statecode.IStateCoderFactory;
import org.eclipse.viatra.dse.util.EMFHelper;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import se.mdh.idt.benji.difference.Difference;
import se.mdh.idt.benji.statecoding.BenchmarkStateCoderFactory;

/**
 * @author Lorenzo Addazi 
 **/
public class Benchmark {
	
	// all solutions
	public static int ALL = 0; 
	
	// properties - context
	private final ResourceSet context; 
	// properties - metamodels
	private final Set<EPackage> metamodels; 
	// properties - models
	private final Set<Resource> models; 
	// properties - constraints
	private final Set<Constraint> constraints; 
	
	// constructor 
	public Benchmark(ResourceSet context, Set<EPackage> metamodels, Set<Resource> models, Set<Constraint> constraints) {
		this.context = context; 
		this.metamodels = metamodels; 
		this.models = models; 
		this.constraints = constraints; 
	}
	
	// generate
	public void generate(int instances, String output) throws ViatraQueryException, IOException {
		// SETUP
		DesignSpaceExplorer designSpaceExplorer = new DesignSpaceExplorer();
		designSpaceExplorer.setMaxNumberOfThreads(1);
		IStateCoderFactory stateCoderFactory = new BenchmarkStateCoderFactory();
		designSpaceExplorer.setStateCoderFactory(stateCoderFactory);
		designSpaceExplorer.setInitialModel(this.context);
		this.metamodels.forEach(metamodel -> designSpaceExplorer.addMetaModelPackage(metamodel)); 
		this.constraints.forEach(constraint -> designSpaceExplorer.addTransformationRule(constraint.difference.getTransformationRule()));
		this.constraints.forEach(constraint -> designSpaceExplorer.addGlobalConstraint(constraint.difference.getGlobalConstraint()));
		this.constraints.forEach(constraint -> designSpaceExplorer.addObjective(Objectives
			.createTrajcetoryCostObjective("[LOWER BOUND] " + constraint.difference.getName())
			.withRuleCost(constraint.difference.getTransformationRule(), 1.0)
			.withHardConstraintOnFitness(constraint.lowerBound, Comparators.HIGHER_IS_BETTER)));
		this.constraints.forEach(constraint -> designSpaceExplorer.addObjective(Objectives
			.createTrajcetoryCostObjective("[UPPER BOUND] " + constraint.difference.getName())
			.withRuleCost(constraint.difference.getTransformationRule(), 1.0)
			.withHardConstraintOnFitness(constraint.upperBound, Comparators.LOWER_IS_BETTER)));
		designSpaceExplorer.addObjective(Objectives.createDepthHardObjective().withMinDepth(1));
		SolutionStore solutionStore = new SolutionStore(instances).logSolutionsWhenFound();
		designSpaceExplorer.setSolutionStore(solutionStore);
		// EXPLORE
		int depthLimit = this.constraints.stream().mapToInt(constraint -> constraint.upperBound).sum();  
		IStrategy strategy = Strategies.createDfsStrategy(depthLimit).continueIfHardObjectivesFulfilled();  
		designSpaceExplorer.startExploration(strategy);
		// SAVE
		System.err.println(designSpaceExplorer.toStringSolutions()); 
		Collection<Solution> solutions = designSpaceExplorer.getSolutions();
		for (Solution solution : solutions) {
			System.err.println(solution.getStateCode()); 
			SolutionTrajectory solutionTrajectory = solution.getShortestTrajectory(); 
			ChangeRecorder changeRecorder = new ChangeRecorder();
			changeRecorder.beginRecording(this.models);
			solutionTrajectory.doTransformationUndoable(this.context);
			ChangeDescription changeDescription = changeRecorder.endRecording();
			changeDescription.applyAndReverse();
			UUID solutionTrajectoryId = UUID.randomUUID();
			EMFHelper.saveModel(changeDescription, output + File.separator + solutionTrajectoryId + File.separator + "Delta.xmi");
			changeDescription.applyAndReverse();
			Set<String> changedModelURIs = changeDescription.getObjectChanges().stream()
				.map(objectChange -> objectChange.getKey().eResource().getURI().toString())
				.collect(Collectors.toSet());
			changedModelURIs.addAll(changeDescription.getResourceChanges().stream()
				.map(resourceChange -> resourceChange.getResourceURI().toString())
				.collect(Collectors.toSet()));  
			Collection<Resource> changedModels = this.models.stream()
				.filter(model -> changedModelURIs.contains(model.getURI().toString()))
				.collect(Collectors.toSet()); 
			for (Resource model : changedModels) {
				Resource clonedResource = (Resource)EMFHelper.clone(model); 
				EMFHelper.saveModel(clonedResource, output + File.separator + solutionTrajectoryId + File.separator + model.getURI().lastSegment());
			}
			solutionTrajectory.undoTransformation();
		}
	}
	
	// constraint
	public static class Constraint {
		
		// properties - lower bound
		private final int lowerBound; 
		// properties - upper bound
		private final int upperBound; 
		// properties - difference
		private final Difference<? extends IPatternMatch, ? extends ViatraQueryMatcher<? extends IPatternMatch>, 
			? extends IQuerySpecification<? extends ViatraQueryMatcher<? extends IPatternMatch>>, 
			? extends IPatternMatch, ? extends ViatraQueryMatcher<? extends IPatternMatch>, 
			? extends IQuerySpecification<? extends ViatraQueryMatcher<? extends IPatternMatch>>, 
			? extends IMatchProcessor<? extends IPatternMatch>> difference; 
		
		// constructor
		public Constraint(int lowerBound, int upperBound, 
			Difference<? extends IPatternMatch, ? extends ViatraQueryMatcher<? extends IPatternMatch>, 
				? extends IQuerySpecification<? extends ViatraQueryMatcher<? extends IPatternMatch>>, 
				? extends IPatternMatch, ? extends ViatraQueryMatcher<? extends IPatternMatch>, 
				? extends IQuerySpecification<? extends ViatraQueryMatcher<? extends IPatternMatch>>, 
				? extends IMatchProcessor<? extends IPatternMatch>> difference) {
			this.lowerBound = lowerBound; 
			this.upperBound = upperBound; 
			this.difference = difference; 
		}

	}
	
}