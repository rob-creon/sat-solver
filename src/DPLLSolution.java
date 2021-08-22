public class DPLLSolution extends Solution {
    public DPLLSolution(BooleanFormula formula) {
        super(formula);
    }

    private Result isSat(BooleanEnvironment env, int depth) {
        if (formula.canEval(env)) {
            return new Result(formula.eval(env), env);
        }
        for (BooleanClause clause : formula.getClauses()) {
            if (clause.isEmpty()) {
                return new Result(false, null);
            }
        }
        for (BooleanClause clause : formula.getClauses()) {
            clause.unitPropagate(env);
        }
        while (env.getVariables()[depth] != BooleanValue.UNASSIGNED) {
            depth++;
            if (depth >= env.getVariables().length) {
                if (formula.eval(env)) {
                    return new Result(true, env);
                } else {
                    return new Result(false, null);
                }
            }
        }
        BooleanEnvironment fEnv = new BooleanEnvironment(env);
        BooleanEnvironment tEnv = new BooleanEnvironment(env);
        fEnv.getVariables()[depth] = BooleanValue.FALSE;
        tEnv.getVariables()[depth] = BooleanValue.TRUE;
        Result fRes = isSat(fEnv, depth + 1);
        Result tRes = isSat(tEnv, depth + 1);
        if (fRes.answer()) {
            return fRes;
        }
        if (tRes.answer()) {
            return tRes;
        }
        return new Result(false, null);
    }

    @Override
    public Result solve() {
        BooleanEnvironment env = formula.getNewEnvironment();
        return isSat(env, 0);
    }
}
