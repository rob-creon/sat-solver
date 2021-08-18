import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A clause of a CNF boolean formula
 *
 * @author Robert Stevens
 * @version 1.0
 */
public class BooleanClause implements BooleanExpression {

    private final List<BooleanLiteral> literals;

    /**
     * Creates a Boolean Clause from a CNF
     *
     * @param clause String representation of the clause in the form: "2 1 3 -4 5 -6"
     *               where each variable is separated by a space and negated variables
     *               are prefixed with -
     */
    public BooleanClause(String clause) {
        literals = new ArrayList<>();
        for (String literal : clause.split(" "))
            literals.add(new BooleanLiteral(literal));
    }

    @Override
    public boolean eval(BooleanFormulaEnvironment instance) {
        for (BooleanLiteral literal : literals)
            if (literal.eval(instance))
                return true;
        return false;
    }

    @Override
    public boolean canEval(BooleanFormulaEnvironment instance) {
        for (BooleanLiteral literal : literals)
            if (literal.canEval(instance))
                return true;
        return false;
    }

    @Override
    public String toString() {
        return "(" + literals.stream().map(Objects::toString).collect(Collectors.joining(" ∨ ")) + ")";
    }
}