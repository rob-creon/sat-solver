import java.util.List;

public abstract class Solution {

    public record Result(boolean answer, BooleanEnvironment solution) {
        @Override
        public String toString() {
            return answer + " " + (solution == null ? "" : solution);
        }
    }

    protected BooleanFormula formula;

    public Solution(BooleanFormula formula) {
        this.formula = formula;
    }

    public abstract Result solve();
}
