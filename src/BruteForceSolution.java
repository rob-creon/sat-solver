public class BruteForceSolution extends Solution {
    public BruteForceSolution(BooleanFormula formula) {
        super(formula);
    }

    private Result isSat(BooleanEnvironment env, int depth) {
        if (depth == env.getVariables().length) { //base case
            return new Result(formula.eval(env), env);
        } else { //recursive case
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
    }

    @Override
    public Result solve() {
        BooleanEnvironment env = formula.getNewEnvironment();
        return isSat(env, 0);
    }
}
