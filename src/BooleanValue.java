/**
 * Boolean Wrapper Enum
 * <p> for supporting UNASSIGNED values in cases when the solver only knows the values of some variables. </p>
 */
public enum BooleanValue {
    TRUE(true, 'T'), FALSE(false, 'F'), UNASSIGNED(null, '-');

    public final Boolean bool;
    public final char ch;

    BooleanValue(Boolean bool, char ch) {
        this.bool = bool;
        this.ch = ch;
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

    public static BooleanValue fromBool(boolean bool) {
        for (BooleanValue val : values()) {
            if (val.bool == bool) {
                return val;
            }
        }
        throw new IllegalArgumentException("Boolean not found??? This should never happen.");
    }
}