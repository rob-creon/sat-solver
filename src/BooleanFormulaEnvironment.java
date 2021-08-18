/**
 * Boolean Formula Instance
 *
 * @author Robert Stevens
 * @version 1.0
 */
public class BooleanFormulaEnvironment {

    /**
     * Boolean Wrapper Enum
     * <p> for supporting UNASSIGNED values in cases when the solver only knows the values of some variables. </p>
     */
    public enum BooleanValue {
        TRUE(true, 'T'), FALSE(false, 'F'), UNASSIGNED(null, '-');

        private final Boolean bool;
        private final char ch;

        BooleanValue(Boolean bool, char ch) {
            this.bool = bool;
            this.ch = ch;
        }

        public boolean getBool() {
            return bool;
        }

        /**
         * Returns the enum corresponding to a character literal.
         *
         * @param ch character literal of the boolean value
         * @return enum corresponding to ch
         * @throws IllegalArgumentException if the character literal does not correspond to any bool value
         */
        public static BooleanValue fromChar(char ch) {
            for (BooleanValue val : values()) {
                if (val.ch == ch) {
                    return val;
                }
            }
            throw new IllegalArgumentException("Value not found: " + ch);
        }
    }

    private final BooleanValue[] variables;

    /**
     * Creates a Boolean Formula Environment from a string of boolean values
     *
     * @param vars a string in the form "TFTFTFFTFTTT..." where a char at index n is the truth value of variable n+1
     */
    public BooleanFormulaEnvironment(String vars) {
        variables = new BooleanValue[vars.length()];
        for (int i = 0; i < vars.length(); ++i) {
            variables[i] = BooleanValue.fromChar(vars.charAt(i));
        }
    }

    /**
     * Creates a Boolean Formula Environment from an array of BooleanValues
     *
     * @param variables array of Xs
     */
    public BooleanFormulaEnvironment(BooleanValue[] variables) {
        this.variables = variables;
    }

    /**
     * @return unmodifiable array of values for variables
     */
    public BooleanValue[] getVariables() {
        return variables;
    }
}
