public class BooleanImplication {

    private final BooleanExpression[] antecedents;
    private final BooleanExpression[] consequents;

    public BooleanImplication(BooleanExpression antecedent, BooleanExpression consequent) {
        this(new BooleanExpression[]{antecedent}, new BooleanExpression[]{consequent});
    }

    public BooleanImplication(BooleanExpression[] antecedents, BooleanExpression[] consequents) {
        this.antecedents = antecedents;
        this.consequents = consequents;
    }

    /**
     * Check if this implication's antecedents are met.
     *
     * @param environment
     * @return false if any antecedent is false, true if all antecedents are true, and unassigned if
     */
    private BooleanValue evalAntecedents(BooleanEnvironment environment) {
        boolean canEval = true;
        for (BooleanExpression ant : antecedents)
            if (!ant.canEval(environment))
                canEval = false;
            else if (!ant.eval(environment))
                return BooleanValue.FALSE;
        return canEval ? BooleanValue.TRUE : BooleanValue.UNASSIGNED;
    }

    /**
     * @param environment formula environment
     * @return returns true unless a contradiction is reached
     */
    public boolean execute(BooleanEnvironment environment) {

        if (!evalAntecedents(environment).bool) {
            return true;
        }
        for (BooleanExpression con : consequents) {
            if (con instanceof BooleanLiteral lit) {
                if (environment.getVariables()[lit.getX() - 1] == BooleanValue.UNASSIGNED) {
                    environment.getVariables()[lit.getX() - 1] = BooleanValue.fromBool(lit.getTruth());
                } else if (environment.getVariables()[lit.getX() - 1].bool != lit.getTruth()) {
                    return false;
                }
            } else {
                BooleanImplication[] subImplications = con.getImplications();
                for (BooleanImplication i : subImplications) {
                    if (!i.execute(environment)) return false;
                }
            }
        }
        return true;
    }
}