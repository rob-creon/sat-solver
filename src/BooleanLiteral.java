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
    public BooleanLiteral(int literal) {
        this(Math.abs(literal), literal > 0);
    }

    private BooleanLiteral(int x, boolean truth) {
        this.x = x;
        this.truth = truth;
    }

    public BooleanLiteral getOpposite() {
        return new BooleanLiteral(x, !truth);
    }

    public int getX() {
        return x;
    }

    public boolean getTruth() {
        return truth;
    }

    @Override
    public boolean eval(BooleanEnvironment env) {
        return (env.getVariables()[x - 1].bool && truth) || (!env.getVariables()[x - 1].bool && !truth);
    }

    @Override
    public boolean canEval(BooleanEnvironment env) {
        return env.getVariables()[x - 1] != BooleanValue.UNASSIGNED;
    }

    @Override
    public BooleanImplication[] getImplications() {
        return new BooleanImplication[]{
                new BooleanImplication(new BooleanExpression[]{}, new BooleanExpression[]{})
        };
    }

    @Override
    public String toString() {
        return (truth ? "" : "¬") + x;
    }
}