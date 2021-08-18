public interface BooleanExpression {
    boolean eval(BooleanFormulaInstance instance);
    boolean canEval(BooleanFormulaInstance instance);
}
