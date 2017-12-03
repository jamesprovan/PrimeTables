import java.util.ArrayList;
import java.util.List;

public class PrimeTable {

    public static void main(String[] args) {

        int primeMaxSize = 1_000_000;

        long timeStart = System.currentTimeMillis();

        PrimeGenerator primeGenerator = new PrimeGenerator(primeMaxSize);
        List<Integer> primes = primeGenerator.generatePrimes();

        long timeEnd = System.currentTimeMillis();

        System.out.println("Calculating primes from 1 " + primeMaxSize + " took " + (timeEnd - timeStart) + " milliseconds - there were " + primes.size() + " primes");
        System.out.println(primes);
    }

}