import java.util.List;

public class PrimeTable {


    public static void main(String[] args) {

        long timeStart = System.currentTimeMillis();

        PrimeGenerator primeGenerator = new PrimeGenerator(Config.maxSize + 1);
        List<Integer> primes = primeGenerator.generatePrimes();

        long timeEnd = System.currentTimeMillis();

        System.out.println("Calculating " + (Config.maxSize + 1) + " primes took " + (timeEnd - timeStart) + " milliseconds.");
        System.out.println(primes);
    }

}