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
            if (!literal.equals("0"))
                literals.add(new BooleanLiteral(Integer.parseInt(literal)));
    }

    @Override
    public boolean eval(BooleanEnvironment instance) {
        for (BooleanLiteral literal : literals)
            if (literal.eval(instance))
                return true;
        return false;
    }

    @Override
    public boolean canEval(BooleanEnvironment instance) {
        for (BooleanLiteral literal : literals)
            if (literal.canEval(instance))
                return true;
        return false;
    }

    @Override
    public BooleanImplication[] getImplications() {
        //TODO
        return null;
        /*
        for (BooleanLiteral literal : literals) {
            List<BooleanExpression> antecedents1 = new ArrayList<>();
            List<BooleanExpression> consequents1 = new ArrayList<>(literals);
            antecedents1.add(literal.getOpposite());
            consequents1.remove(literal);

            List<BooleanExpression> antecedents2 = new ArrayList<>(consequents1);
            List<BooleanExpression> consequents2 = new ArrayList<>(antecedents1);
        }
         */
    }

    public int getHighestX() {
        int max = 0;
        for (BooleanLiteral l : literals)
            if (l.getX() > max)
                max = l.getX();
        return max;
    }

    @Override
    public String toString() {
        return "(" + literals.stream().map(Objects::toString).collect(Collectors.joining(" ∨ ")) + ")";
    }
}