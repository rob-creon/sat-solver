import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Boolean Formula Object.
 *
 * <p> Represents a boolean formula in conjunctive normative form. </p>
 *
 * @author Robert Stevens
 * @version 1.0
 */
public class BooleanFormula implements BooleanExpression {

    private final List<BooleanClause> clauses;

    /**
     * Creates a Boolean Formula object from a multiline string representation of a CNF formula.
     *
     * @param formula multiline string representation of a formula
     */
    public BooleanFormula(String formula) {
        clauses = new ArrayList<>();
        for (String line : formula.split("\n")) {
            line = line.trim();
            if (!line.equals("") && line.charAt(0) != 'c' && line.charAt(0) != 'p' && line.charAt(0) != '%' && line.charAt(0) != '%' && line.charAt(0) != '0')
                clauses.add(new BooleanClause(line));
        }
    }

    /**
     * Creates an empty BooleanEnvironment with all unassigned variables corresponding to the variables in this formula.
     *
     * @return a completely unassigned BooleanEnvironment
     */
    public BooleanEnvironment getNewEnvironment() {
        int highestX = 0;
        for (BooleanClause clause : clauses) {
            if (clause.getHighestX() > highestX)
                highestX = clause.getHighestX();
        }
        return new BooleanEnvironment(repeat(highestX, "-"));
    }

    private static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    @Override
    public boolean eval(BooleanEnvironment instance) {
        for (BooleanClause clause : clauses)
            if (!clause.eval(instance))
                return false;
        return true;
    }

    @Override
    public boolean canEval(BooleanEnvironment instance) {
        for (BooleanClause clause : clauses)
            if (!clause.canEval(instance))
                return false;
        return true;
    }

    @Override
    public BooleanImplication[] getImplications() {
        List<BooleanImplication> implications = new ArrayList<>();
        for (BooleanClause clause : clauses)
            implications.addAll(List.of(clause.getImplications()));
        return implications.toArray(BooleanImplication[]::new);
    }

    @Override
    public String toString() {
        return clauses.stream().map(Objects::toString).collect(Collectors.joining(" ∧ "));
    }
}
