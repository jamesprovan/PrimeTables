import java.util.ArrayList;
import java.util.List;

public class PrimeTable {

    public static void main(String[] args) {

        int primeMaxSize = 1000_000;

        long timeStart = System.currentTimeMillis();

        List<Integer> primes = new ArrayList<>();

        for (int i = 1; i < primeMaxSize; i++) {
                if (isPrime(i)) {
                    primes.add(i);
                }
        }

        long timeEnd = System.currentTimeMillis();

        System.out.println("Calculating primes from 1 " + primeMaxSize + " took " + (timeEnd - timeStart) + " milliseconds - there were " + primes.size() + " primes");
        System.out.println(primes);
    }


    private static boolean isPrime(int input) {

        int sqrtOfPrime = (int) Math.sqrt(input);  /* find the square root of this prime. This significantly reduces the amount of looping required. */

    	/* Increment from 2, checking if any number up to the square route divides the maybePrime number with no remainder. */
        /* If it does, it's not a prime and return false. */
        for (int i = 2; i <= sqrtOfPrime; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        /* No prime numbers below 2 exist, so return false. */
        if (input < 2) {
            return false;
        }

        /* If neither of the above conditions were triggered, then this number is prime! */
        return true;

    }
}