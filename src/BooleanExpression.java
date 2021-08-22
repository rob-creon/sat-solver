/**
 * Boolean Expression Interface
 *
 * <p> Represents a boolean expression that may be evaluated using a formula instance. </p>
 *
 * @author Robert Stevens
 * @version 1.0
 */

public interface BooleanExpression {
    /**
     * Returns the truth value of this expression given the values of variables by the formula instance.
     *
     * @param instance formula instance
     * @return the truth value of the expression
     */
    boolean eval(BooleanEnvironment instance);

    /**
     * Returns whether this expression can be evaluated with a given formula instance.
     *
     * @param instance formula instance
     * @return true if the expression may be evaluated, false if not
     */
    boolean canEval(BooleanEnvironment instance);

    /**
     * Returns a list of implications that are derived from assuming this clause to be true
     *
     * @return list of implications
     */
    BooleanImplication[] getImplications();
}
