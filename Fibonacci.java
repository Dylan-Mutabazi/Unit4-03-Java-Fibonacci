//imports
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This program reads input file for n values,
 * computes the nth Fibonacci number using recursion.
 *
 * It writes the results to output.txt.
 *
 * @author Dylan
 * @version 1.0
 * @since 2025-December
 */
final class Fibonacci {
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Computes the nth Fibonacci number using recursion.
     *
     * @param n the value to compute
     * @return nth Fibonacci number
     */

    public static int recFib(final int n) {

        // if n is 0 or 1, return n
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return recFib(n - 1) + recFib(n - 2);
    }

    /**
     * Program entry point.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {

        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try {
            // Create Scanner object to read the file

            Scanner scanner = new Scanner(inputFile);
            FileWriter out = new FileWriter(outputFile);

            //Checks if line has next line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // Handle empty lines
                if (line.isEmpty()) {
                    out.write("\n");
                    continue;
                }

                try {
                    int num = Integer.parseInt(line);

                    if (num < 0) {
                        out.write(line
                            + " is a negative number \n");
                        continue;
                    }

                    int result = recFib(num);
                    out.write(result + "\n");

                } catch (NumberFormatException e) {
                    out.write("Invalid input: "
                            + line + "\n");
                }
            }

            scanner.close();
            out.close();

        } catch (FileNotFoundException e) {
            System.err.println("Input file not found");
        } catch (IOException e) {
            System.err.println("Error writing output file");
        }
    }
}
