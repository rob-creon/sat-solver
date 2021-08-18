/**
 * A boolean literal -- either p or NOT(p)
 * <p>
 * A boolean expression
 *
 * @author Robert Stevens
 * @version 1.0
 */
public class BooleanLiteral implements BooleanExpression {

    private final int x;
    private final boolean truth;

    /**
     * Creates a boolean literal from its string representation.
     *
     * <p> Example: "-1" is NOT(X_1), "2" is X_2, "-3" is NOT(X_3), etc.</p>
     *
     * @param literal
     */
    public BooleanLiteral(String literal) {
        int value = Integer.parseInt(literal);
        truth = value > 0;
        x = Math.abs(value);
    }

    public int getX() {
        return x;
    }

    public boolean getTruth() {
        return truth;
    }

    @Override
    public boolean eval(BooleanFormulaEnvironment instance) {
        return (instance.getVariables()[x - 1].getBool() && truth) || (!instance.getVariables()[x - 1].getBool() && !truth);
    }

    @Override
    public boolean canEval(BooleanFormulaEnvironment instance) {
        return instance.getVariables()[x - 1] != BooleanFormulaEnvironment.BooleanValue.UNASSIGNED;
    }

    @Override
    public String toString() {
        return (truth ? "" : "¬") + x;
    }
}