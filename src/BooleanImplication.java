import java.util.List;

public class BooleanImplication {
    private List<BooleanExpression> antecedents;
    private List<BooleanExpression> consequents;

    public BooleanImplication(BooleanExpression expression) {

    }

    public BooleanImplication(List<BooleanExpression> antecedents, List<BooleanExpression> consequents) {
        this.antecedents = antecedents;
        this.consequents = consequents;
    }

    /**
     * Check if this implication's antecedents are met.
     *
     * @param environment
     * @return false if any antecedent is false, true if all antecedents are true, and unassigned if
     */
    private BooleanValue evalAntecedents(BooleanFormulaEnvironment environment) {
        boolean canEval = true;
        for (BooleanExpression ant : antecedents)
            if (!ant.canEval(environment))
                canEval = false;
            else if (!ant.eval(environment))
                return BooleanValue.FALSE;
        return canEval ? BooleanValue.TRUE : BooleanValue.UNASSIGNED;
    }

    /**
     * @param environment
     * @return returns true unless a contradiction is reached
     */
    public boolean execute(BooleanFormulaEnvironment environment) {

        if (!evalAntecedents(environment).bool) {
            return true;
        }
        for (BooleanExpression con : consequents) {
            if (con instanceof BooleanLiteral lit) {
                if (environment.getVariables()[lit.getX()] == BooleanValue.UNASSIGNED) {
                    environment.getVariables()[lit.getX()] = BooleanValue.fromBool(lit.getTruth());
                } else if (environment.getVariables()[lit.getX()].bool != lit.getTruth()) {
                    return false;
                }
            }
            if (!new BooleanImplication(con).execute(environment)) {
                return false;
            }
        }
        return true;
    }
}