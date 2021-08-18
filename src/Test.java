public class Test {
    public static void main(String[] args) {
        BooleanFormula formula = new BooleanFormula("""
                1 2
                -1 -2
                1 -2
                """);
        BooleanFormulaInstance formulaInstance = new BooleanFormulaInstance("TF");

        System.out.println(formula.toString());

        System.out.println(formula.eval(formulaInstance));
    }
}
