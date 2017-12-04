package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PrimeTableCSVWriter implements OutputDevice {

    private List<Integer> primes;

    public PrimeTableCSVWriter(List<Integer> primes) {
        this.primes = primes;
    }

    @Override
    public void performOutput() {
        // Save output to the current directory
        String currentWorkingDir = System.getProperty("user.dir") + File.separator + "JamesPrimes.csv";
        Path path = Paths.get(currentWorkingDir);

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

    private void writeLine(int lineNumber, List<Integer> primes, BufferedWriter writer) throws IOException {
        if (lineNumber == 0) {
            writer.write(",");
            for (Integer prime : primes) {
                writer.write(prime + ",");
            }
        } else {
            int firstPrime = primes.get(lineNumber - 1);
            writer.write(firstPrime + ",");
            for (Integer prime : primes) {
                long multiplication = (long) firstPrime * (long) prime;
                writer.write(multiplication + ",");
            }
        }
    }

}
