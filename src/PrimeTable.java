import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PrimeTable {


    public static void main(String[] args) {

        System.out.println("Calculating primes...");
        long timeStart = System.currentTimeMillis();
        PrimeGenerator primeGenerator = new PrimeGenerator(Config.maxSize);
        List<Integer> primes = primeGenerator.generatePrimes();
        long timeEnd = System.currentTimeMillis();
        System.out.println("Calculating " + (Config.maxSize) + " primes took " + (timeEnd - timeStart) + " milliseconds.");


        System.out.println("Building table... ");
        long tableStart = System.currentTimeMillis();
        buildAndSavePrimeTable(primes);
        long tableEnd = System.currentTimeMillis();
        System.out.println("Table saved. This took " + (tableEnd - tableStart) + " milliseconds");
    }

    private static void buildAndSavePrimeTable(List<Integer> primes) {
        Path path = Paths.get("C:\\primeOutput\\JamesPrimes.csv");
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);

            for (int i = 0; i <= primes.size(); i++) {
                writeLine(i, primes, writer);
                writer.write("\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeLine(int lineNumber, List<Integer> primes, BufferedWriter writer) throws IOException {
        if (lineNumber == 0) {
            writer.write(",");
            for (Integer prime : primes) {
                writer.write(prime + ",");
            }
        } else {
            int firstPrime = primes.get(lineNumber - 1);
            writer.write(firstPrime + ",");
            for (int count = 0; count < primes.size(); count++) {
                long multiplication = (long) firstPrime * (long) primes.get(count);
                writer.write(multiplication + ",");
            }
        }
    }


}