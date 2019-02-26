/**
 * Generated from platform:/resource/se.mdh.idt.benji/src/se/mdh/idt/benji/trace/api/TraceQueries.vql
 */
package se.mdh.idt.benji.trace.api;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import se.mdh.idt.benji.trace.Trace;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         // trace - current element
 *         pattern current (trace : Trace, current : EObject) {
 *         	Trace.current (trace, current); 	
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class Current extends BaseGeneratedEMFQuerySpecification<Current.Matcher> {
  /**
   * Pattern-specific match representation of the se.mdh.idt.benji.trace.api.current pattern,
   * to be used in conjunction with {@link Matcher}.
   * 
   * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
   * Each instance is a (possibly partial) substitution of pattern parameters,
   * usable to represent a match of the pattern in the result of a query,
   * or to specify the bound (fixed) input parameters when issuing a query.
   * 
   * @see Matcher
   *  @see Processor
   * 
   */
  public static abstract class Match extends BasePatternMatch {
    private Trace fTrace;
    
    private EObject fCurrent;
    
    private static List<String> parameterNames = makeImmutableList("trace", "current");
    
    private Match(final Trace pTrace, final EObject pCurrent) {
      this.fTrace = pTrace;
      this.fCurrent = pCurrent;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("trace".equals(parameterName)) return this.fTrace;
      if ("current".equals(parameterName)) return this.fCurrent;
      return null;
    }
    
    public Trace getTrace() {
      return this.fTrace;
    }
    
    public EObject getCurrent() {
      return this.fCurrent;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("trace".equals(parameterName) ) {
          this.fTrace = (Trace) newValue;
          return true;
      }
      if ("current".equals(parameterName) ) {
          this.fCurrent = (EObject) newValue;
          return true;
      }
      return false;
    }
    
    public void setTrace(final Trace pTrace) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrace = pTrace;
    }
    
    public void setCurrent(final EObject pCurrent) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fCurrent = pCurrent;
    }
    
    @Override
    public String patternName() {
      return "se.mdh.idt.benji.trace.api.current";
    }
    
    @Override
    public List<String> parameterNames() {
      return Current.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fTrace, fCurrent};
    }
    
    @Override
    public Current.Match toImmutable() {
      return isMutable() ? newMatch(fTrace, fCurrent) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"trace\"=" + prettyPrintValue(fTrace) + ", ");
      result.append("\"current\"=" + prettyPrintValue(fCurrent));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fTrace, fCurrent);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Current.Match)) {
          Current.Match other = (Current.Match) obj;
          return Objects.equals(fTrace, other.fTrace) && Objects.equals(fCurrent, other.fCurrent);
      } else {
          // this should be infrequent
          if (!(obj instanceof IPatternMatch)) {
              return false;
          }
          IPatternMatch otherSig  = (IPatternMatch) obj;
          return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
      }
    }
    
    @Override
    public Current specification() {
      return Current.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Current.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCurrent the fixed value of pattern parameter current, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Current.Match newMutableMatch(final Trace pTrace, final EObject pCurrent) {
      return new Mutable(pTrace, pCurrent);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCurrent the fixed value of pattern parameter current, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Current.Match newMatch(final Trace pTrace, final EObject pCurrent) {
      return new Immutable(pTrace, pCurrent);
    }
    
    private static final class Mutable extends Current.Match {
      Mutable(final Trace pTrace, final EObject pCurrent) {
        super(pTrace, pCurrent);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Current.Match {
      Immutable(final Trace pTrace, final EObject pCurrent) {
        super(pTrace, pCurrent);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the se.mdh.idt.benji.trace.api.current pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * // trace - current element
   * pattern current (trace : Trace, current : EObject) {
   * 	Trace.current (trace, current); 	
   * }
   * </pre></code>
   * 
   * @see Match
   *  @see Processor
   * @see Current
   * 
   */
  public static class Matcher extends BaseMatcher<Current.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Current.Matcher on(final ViatraQueryEngine engine) {
      // check if matcher already exists
      Matcher matcher = engine.getExistingMatcher(querySpecification());
      if (matcher == null) {
          matcher = (Matcher)engine.getMatcher(querySpecification());
      }
      return matcher;
    }
    
    /**
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * @return an initialized matcher
     * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
     * 
     */
    public static Current.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TRACE = 0;
    
    private static final int POSITION_CURRENT = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Current.Matcher.class);
    
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    private Matcher() {
      super(querySpecification());
    }
    
    /**
     * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCurrent the fixed value of pattern parameter current, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Current.Match> getAllMatches(final Trace pTrace, final EObject pCurrent) {
      return rawStreamAllMatches(new Object[]{pTrace, pCurrent}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCurrent the fixed value of pattern parameter current, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Current.Match> streamAllMatches(final Trace pTrace, final EObject pCurrent) {
      return rawStreamAllMatches(new Object[]{pTrace, pCurrent});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCurrent the fixed value of pattern parameter current, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Current.Match> getOneArbitraryMatch(final Trace pTrace, final EObject pCurrent) {
      return rawGetOneArbitraryMatch(new Object[]{pTrace, pCurrent});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCurrent the fixed value of pattern parameter current, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Trace pTrace, final EObject pCurrent) {
      return rawHasMatch(new Object[]{pTrace, pCurrent});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCurrent the fixed value of pattern parameter current, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Trace pTrace, final EObject pCurrent) {
      return rawCountMatches(new Object[]{pTrace, pCurrent});
    }
    
    /**
     * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCurrent the fixed value of pattern parameter current, or null if not bound.
     * @param processor the action that will process each pattern match.
     * 
     */
    public void forEachMatch(final Trace pTrace, final EObject pCurrent, final Consumer<? super Current.Match> processor) {
      rawForEachMatch(new Object[]{pTrace, pCurrent}, processor);
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCurrent the fixed value of pattern parameter current, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Trace pTrace, final EObject pCurrent, final Consumer<? super Current.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pTrace, pCurrent}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pCurrent the fixed value of pattern parameter current, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Current.Match newMatch(final Trace pTrace, final EObject pCurrent) {
      return Current.Match.newMatch(pTrace, pCurrent);
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Trace> rawStreamAllValuesOftrace(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TRACE, parameters).map(Trace.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Trace> getAllValuesOftrace() {
      return rawStreamAllValuesOftrace(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Trace> streamAllValuesOftrace() {
      return rawStreamAllValuesOftrace(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Trace> streamAllValuesOftrace(final Current.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Trace> streamAllValuesOftrace(final EObject pCurrent) {
      return rawStreamAllValuesOftrace(new Object[]{null, pCurrent});
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Trace> getAllValuesOftrace(final Current.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Trace> getAllValuesOftrace(final EObject pCurrent) {
      return rawStreamAllValuesOftrace(new Object[]{null, pCurrent}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for current.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<EObject> rawStreamAllValuesOfcurrent(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CURRENT, parameters).map(EObject.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for current.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfcurrent() {
      return rawStreamAllValuesOfcurrent(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for current.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfcurrent() {
      return rawStreamAllValuesOfcurrent(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for current.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfcurrent(final Current.Match partialMatch) {
      return rawStreamAllValuesOfcurrent(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for current.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfcurrent(final Trace pTrace) {
      return rawStreamAllValuesOfcurrent(new Object[]{pTrace, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for current.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfcurrent(final Current.Match partialMatch) {
      return rawStreamAllValuesOfcurrent(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for current.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfcurrent(final Trace pTrace) {
      return rawStreamAllValuesOfcurrent(new Object[]{pTrace, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Current.Match tupleToMatch(final Tuple t) {
      try {
          return Current.Match.newMatch((Trace) t.get(POSITION_TRACE), (EObject) t.get(POSITION_CURRENT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Current.Match arrayToMatch(final Object[] match) {
      try {
          return Current.Match.newMatch((Trace) match[POSITION_TRACE], (EObject) match[POSITION_CURRENT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Current.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Current.Match.newMutableMatch((Trace) match[POSITION_TRACE], (EObject) match[POSITION_CURRENT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    /**
     * @return the singleton instance of the query specification of this pattern
     * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
     * 
     */
    public static IQuerySpecification<Current.Matcher> querySpecification() {
      return Current.instance();
    }
  }
  
  /**
   * A match processor tailored for the se.mdh.idt.benji.trace.api.current pattern.
   * 
   * Clients should derive an (anonymous) class that implements the abstract process().
   * 
   */
  public static abstract class Processor implements Consumer<Current.Match> {
    /**
     * Defines the action that is to be executed on each match.
     * @param pTrace the value of pattern parameter trace in the currently processed match
     * @param pCurrent the value of pattern parameter current in the currently processed match
     * 
     */
    public abstract void accept(final Trace pTrace, final EObject pCurrent);
    
    @Override
    public void accept(final Current.Match match) {
      accept(match.getTrace(), match.getCurrent());
    }
  }
  
  private Current() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Current instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Current.Matcher instantiate(final ViatraQueryEngine engine) {
    return Current.Matcher.on(engine);
  }
  
  @Override
  public Current.Matcher instantiate() {
    return Current.Matcher.create();
  }
  
  @Override
  public Current.Match newEmptyMatch() {
    return Current.Match.newEmptyMatch();
  }
  
  @Override
  public Current.Match newMatch(final Object... parameters) {
    return Current.Match.newMatch((se.mdh.idt.benji.trace.Trace) parameters[0], (org.eclipse.emf.ecore.EObject) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: se.mdh.idt.benji.trace.api.Current (visibility: PUBLIC, simpleName: Current, identifier: se.mdh.idt.benji.trace.api.Current, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: se.mdh.idt.benji.trace.api) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: se.mdh.idt.benji.trace.api.Current (visibility: PUBLIC, simpleName: Current, identifier: se.mdh.idt.benji.trace.api.Current, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: se.mdh.idt.benji.trace.api) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Current INSTANCE = new Current();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private static final Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private static final Current.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_trace = new PParameter("trace", "se.mdh.idt.benji.trace.Trace", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.mdh.se/idt/benji/trace/Trace", "Trace")), PParameterDirection.INOUT);
    
    private final PParameter parameter_current = new PParameter("current", "org.eclipse.emf.ecore.EObject", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EObject")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_trace, parameter_current);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "se.mdh.idt.benji.trace.api.current";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("trace","current");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_trace = body.getOrCreateVariableByName("trace");
          PVariable var_current = body.getOrCreateVariableByName("current");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.mdh.se/idt/benji/trace/Trace", "Trace")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_current), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_trace, parameter_trace),
             new ExportedParameter(body, var_current, parameter_current)
          ));
          // 	Trace.current (trace, current)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.mdh.se/idt/benji/trace/Trace", "Trace")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.mdh.se/idt/benji/trace/Trace", "Trace", "current")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new Equality(body, var__virtual_0_, var_current);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
