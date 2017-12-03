import org.apache.commons.math3.primes.Primes;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static junit.framework.Assert.assertTrue;

public class PrimeTableTest {

    @Test
    public void testPrimes() {

        int primeMaxSize = 1_000_000;

        // Generate my primes
        PrimeGenerator generator = new PrimeGenerator(primeMaxSize);
        List<Integer> jamesPrimes = generator.generatePrimes();

        // Generate primes from the Apache Math library and verify against my own primes
        Set<Integer> apachePrimes = generateApachePrimes(primeMaxSize);
        assertTrue(apachePrimes.containsAll(jamesPrimes));
        assertTrue(jamesPrimes.containsAll(apachePrimes));
    }


    private Set<Integer> generateApachePrimes(int maxSize) {
        TreeSet<Integer> apachePrimes = new TreeSet<>();
        int i = 2;
        while (i <= maxSize) {
            apachePrimes.add(i);
            i++;
            i = Primes.nextPrime(i);
        }
        return apachePrimes;

    }
}
