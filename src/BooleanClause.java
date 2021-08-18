import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BooleanClause implements BooleanExpression {

    private final List<BooleanLiteral> literals;

    public BooleanClause(String clause) {
        literals = new ArrayList<>();
        for (String literal : clause.split(" "))
            literals.add(new BooleanLiteral(literal));
    }

    @Override
    public boolean eval(BooleanFormulaInstance instance) {
        for (BooleanLiteral literal : literals)
            if (literal.eval(instance))
                return true;
        return false;
    }

    @Override
    public boolean canEval(BooleanFormulaInstance instance) {
        for (BooleanLiteral literal : literals)
            if (!literal.canEval(instance))
                return false;
        return false;
    }

    @Override
    public String toString() {
        return "(" + literals.stream().map(Objects::toString).collect(Collectors.joining(" ∨ ")) + ")";
    }
}