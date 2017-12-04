import output.OutputDevice;
import output.PrimeTableCSVWriter;
import output.PrimeTableConsoleOutput;

import java.util.List;

public class PrimeTable {

    public static void main(String[] args) {

        // Defaults
        Integer tableSize = 20;
        boolean outputToCSV = false;


        // Read input parameters
        if (args.length > 0) {
            tableSize = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            outputToCSV = Boolean.parseBoolean(args[1]);
        }

        List<Integer> primes = calculatePrimes(tableSize);
        createPrimesTable(primes, outputToCSV);
    }

    private static List<Integer> calculatePrimes(Integer n) {
        System.out.println("Calculating primes...");

        long timeStart = System.currentTimeMillis();
        PrimeGenerator primeGenerator = new PrimeGenerator(n);
        List<Integer> primes = primeGenerator.generatePrimes();
        long timeEnd = System.currentTimeMillis();

        System.out.println("Calculating " + n + " primes took " + (timeEnd - timeStart) + "ms.");

        return primes;
    }

    private static void createPrimesTable(List<Integer> primes, boolean outputToCSV) {
        System.out.println("Building table... ");

        long tableStart = System.currentTimeMillis();

        OutputDevice device;

        if (outputToCSV) {
            device = new PrimeTableCSVWriter(primes);
        } else {
            device = new PrimeTableConsoleOutput(primes);
        }

        device.performOutput();

        long tableEnd = System.currentTimeMillis();
        System.out.println("Table created. This took " + (tableEnd - tableStart) + "ms.");
    }

}