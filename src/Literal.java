public class Literal implements BooleanExpression {

    private final int x;
    private final boolean truth;

    public Literal(String literal) {
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
    public boolean eval(FormulaInstance instance) {
        return instance.getVariables()[x].getBool() && truth;
    }

    @Override
    public boolean canEval(FormulaInstance instance) {
        return instance.getVariables()[x] != FormulaInstance.Value.UNASSIGNED;
    }
}