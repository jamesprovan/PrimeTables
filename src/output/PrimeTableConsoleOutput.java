package output;

import java.util.List;

public class PrimeTableConsoleOutput implements OutputDevice {

    private List<Integer> primes;

    public PrimeTableConsoleOutput(List<Integer> primes) {
        this.primes = primes;
    }

    @Override
    public void performOutput() {
        for (int i = 0; i <= primes.size(); i++) {
            System.out.println(createLine(i, primes));
        }
    }

    private StringBuffer createLine(int lineNumber, List<Integer> primes) {
        StringBuffer buffer = new StringBuffer();
        if (lineNumber == 0) {
            buffer.append(",");
            for (Integer prime : primes) {
                buffer.append(prime);
                buffer.append(",");
            }
        } else {
            int firstPrime = primes.get(lineNumber - 1);
            buffer.append(firstPrime);
            buffer.append(",");
            for (Integer prime : primes) {
                long multiplication = (long) firstPrime * (long) prime;
                buffer.append(multiplication);
                buffer.append(",");
            }
        }
        return buffer;
    }

}
