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
        for (String line : formula.split("\n"))
            clauses.add(new BooleanClause(line));
    }

    @Override
    public boolean eval(BooleanFormulaEnvironment instance) {
        for (BooleanClause clause : clauses)
            if (!clause.eval(instance))
                return false;
        return true;
    }

    @Override
    public boolean canEval(BooleanFormulaEnvironment instance) {
        for (BooleanClause clause : clauses)
            if (!clause.canEval(instance))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return clauses.stream().map(Objects::toString).collect(Collectors.joining(" ∧ "));
    }
}
