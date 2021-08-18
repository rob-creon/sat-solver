import java.util.ArrayList;
import java.util.List;

/**
 * Boolean Logic Formula Object.
 *
 * @author Robert Stevens
 * @version 1.0
 */
public class Formula {

    private List<Clause> clauses;

    /**
     * Creates a Formula object from a multiline string representation of a CNF formula.
     *
     * @param formula multiline string representation of a formula
     */
    public Formula(String formula) {
        clauses = new ArrayList<>();

        // Each line of the formula is a clause
        for (String line : formula.split("\n")) {
            clauses.add(new Clause(line));
        }
    }
}
