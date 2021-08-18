public interface BooleanExpression {
    boolean eval(FormulaInstance instance);
    boolean canEval(FormulaInstance instance);
}
