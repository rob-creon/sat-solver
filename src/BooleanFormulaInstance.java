
public class BooleanFormulaInstance {

    public enum Value {
        TRUE(true, 'T'), FALSE(false, 'F'), UNASSIGNED(null, '-');

        private final Boolean bool;
        private final char ch;

        Value(Boolean bool, char ch) {
            this.bool = bool;
            this.ch = ch;
        }

        public boolean getBool() {
            return bool;
        }

        public static Value fromChar(char ch) {
            for (Value val : values()) {
                if (val.ch == ch) {
                    return val;
                }
            }
            throw new IllegalArgumentException("Value not found: " + ch);
        }
    }

    private final Value[] variables;

    public BooleanFormulaInstance(String vars) {
        variables = new Value[vars.length()];
        for (int i = 0; i < vars.length(); ++i) {
            variables[i] = Value.fromChar(vars.charAt(i));
        }
    }

    public BooleanFormulaInstance(Value[] variables) {
        this.variables = variables;
    }

    public Value[] getVariables() {
        return variables;
    }
}
