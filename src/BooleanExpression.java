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
    boolean eval(BooleanFormulaEnvironment instance);

    /**
     * Returns whether this expression can be evaluated with a given formula instance.
     *
     * @param instance formula instance
     * @return true if the expression may be evaluated, false if not
     */
    boolean canEval(BooleanFormulaEnvironment instance);
}
