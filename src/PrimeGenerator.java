import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator {


    private int maxSize;

    public PrimeGenerator(int maxSize) {
        this.maxSize = maxSize;
    }


    public List<Integer> generatePrimes(){

        List<Integer> primes = new ArrayList<>();

        int i = 2;
        while (primes.size() < maxSize) {
            if (isPrime(i)) {
                primes.add(i);
            }
            i++;
        }
        return primes;
    }

    public boolean isPrime(int input) {

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
