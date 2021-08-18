import java.util.ArrayList;

/**
 * Boolean Logic Formula Object.
 *
 * @author Robert Stevens
 */
public class Formula {

    private ArrayList<Clause> clauses;

    private static class Clause {
        private ArrayList<Literal> literals;
    }

    private static class Literal {
        private final int x;
        private final boolean truth;

        public Literal(int x, boolean truth) {
            this.x = x;
            this.truth = truth;
        }
    }
}
