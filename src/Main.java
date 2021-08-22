import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bruteforce: " + benchmark(BruteForceSolution::new, "uf20", 10) + "ms");
        System.out.println("DPLL: " + benchmark(DPLLSolution::new, "uf20", 10) + "ms");
    }

    private static long benchmark(Function<BooleanFormula, Solution> solutionConstructor, String prefix, int max) {
        long total = 0;
        for (int i = 1; i <= max; i++) {
            String filename = "dataset/" + prefix + "-0" + i + ".cnf";
            BooleanFormula formula = loadFormula(filename);
            Solution solution = solutionConstructor.apply(formula);

            long start = System.currentTimeMillis();
            if (!solution.solve().answer()) {
                System.out.println("A satisfiable formula returned not sat: " + filename);
            }
            total += System.currentTimeMillis() - start;
        }
        return total;
    }

    private static BooleanFormula loadFormula(String filename) {
        StringBuilder fileContents = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContents.append(line).append("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return new BooleanFormula(fileContents.toString());
    }
}
