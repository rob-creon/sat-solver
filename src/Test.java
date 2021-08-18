/**
 * Testing class for verifying the k-SAT-CNF backend.
 *
 * @author Robert Stevens
 * @version 1.0
 */

public class Test {
    public static void main(String[] args) {

        BooleanFormulaEnvironment formulaInstance = new BooleanFormulaEnvironment("TF");

        BooleanLiteral l1 = new BooleanLiteral("1");    //T
        BooleanLiteral l2 = new BooleanLiteral("2");    //F
        BooleanLiteral ln1 = new BooleanLiteral("-1");  //F
        BooleanLiteral ln2 = new BooleanLiteral("-2");  //T
        assert (l1.eval(formulaInstance));
        assert (!l2.eval(formulaInstance));
        assert (!ln1.eval(formulaInstance));
        assert (ln2.eval(formulaInstance));

        BooleanClause cl1 = new BooleanClause("1 2");   //T
        BooleanClause cl2 = new BooleanClause("-1 2");  //F
        BooleanClause cl3 = new BooleanClause("-1 -2"); //T
        BooleanClause cl4 = new BooleanClause("-1 -2"); //T
        assert (cl1.eval(formulaInstance));
        assert (!cl2.eval(formulaInstance));
        assert (cl3.eval(formulaInstance));
        assert (cl4.eval(formulaInstance));

        BooleanFormula formula1 = new BooleanFormula("""
                1 2
                -1 -2
                1 -2
                """);
        System.out.println(formula1);
        assert (formula1.eval(formulaInstance));

        BooleanFormula formula2 = new BooleanFormula("""
                1 -2
                1 2
                """);
        System.out.println(formula2);
        assert (formula2.eval(formulaInstance));

        BooleanFormula formula3 = new BooleanFormula("""
                -1 -2
                -1 2
                """);
        System.out.println(formula3);
        assert (!formula3.eval(formulaInstance));
    }
}
