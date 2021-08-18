
public class FormulaInstance {

    public enum Value {
        TRUE(true), FALSE(false), UNASSIGNED(null);

        private final Boolean bool;
        Value(Boolean bool) {
            this.bool = bool;
        }

        public boolean getBool() {
            return bool;
        }
    }

    private final Value[] variables;

    public FormulaInstance(Value[] variables) {
        this.variables = variables;
    }

    public Value[] getVariables() {
        return variables;
    }
}
