public class BooleanLiteral implements BooleanExpression {

    private final int x;
    private final boolean truth;

    public BooleanLiteral(String literal) {
        int value = Integer.parseInt(literal);
        truth = value < 0;
        x = Math.abs(value);
    }

    public int getX() {
        return x;
    }

    public boolean getTruth() {
        return truth;
    }

    @Override
    public boolean eval(BooleanFormulaInstance instance) {
        return instance.getVariables()[x - 1].getBool() && truth;
    }

    @Override
    public boolean canEval(BooleanFormulaInstance instance) {
        return instance.getVariables()[x - 1] != BooleanFormulaInstance.Value.UNASSIGNED;
    }

    @Override
    public String toString() {
        return (truth ? "" : "¬") + x;
    }
}