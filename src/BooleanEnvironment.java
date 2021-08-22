import java.util.Arrays;

/**
 * Boolean Formula Instance
 *
 * @author Robert Stevens
 * @version 1.0
 */
public class BooleanEnvironment {

    private BooleanValue[] variables;

    /**
     * Creates a Boolean Environment from a string of boolean values
     *
     * @param vars a string in the form "TFTFTFFTFTTT..." where a char at index n is the truth value of variable n+1
     */
    public BooleanEnvironment(String vars) {
        variables = new BooleanValue[vars.length()];
        for (int i = 0; i < vars.length(); ++i) {
            variables[i] = BooleanValue.fromChar(vars.charAt(i));
        }
    }

    /**
     * Creates a Boolean Environment from an array of BooleanValues
     *
     * @param variables array of Xs
     */
    public BooleanEnvironment(BooleanValue[] variables) {
        this.variables = variables;
    }

    /**
     * Creates a deep copy of a Boolean Environment
     *
     * @param env
     */
    public BooleanEnvironment(BooleanEnvironment env) {
        this.variables = Arrays.copyOf(env.getVariables(), env.getVariables().length);
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
