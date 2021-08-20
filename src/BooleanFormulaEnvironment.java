/**
 * Boolean Formula Instance
 *
 * @author Robert Stevens
 * @version 1.0
 */
public class BooleanFormulaEnvironment {

    private BooleanValue[] variables;

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
     * @return array of values for variables
     */
    public BooleanValue[] getVariables() {
        return variables;
    }

    /**
     * @return string representation of this environment
     */
    @Override
    public String toString() {
        char[] str = new char[variables.length];
        for (int i = 0; i < variables.length; ++i) {
            str[i] = variables[i].ch;
        }
        return String.valueOf(str);
    }

}
