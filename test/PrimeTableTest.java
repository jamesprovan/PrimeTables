import org.apache.commons.math3.primes.Primes;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static junit.framework.Assert.assertTrue;

public class PrimeTableTest {

    @Test
    public void testPrimes() {
        // Generate my primes
        PrimeGenerator generator = new PrimeGenerator(100_000);
        List<Integer> jamesPrimes = generator.generatePrimes();

        // Generate primes from the Apache Math library and verify against my own primes
        Set<Integer> apachePrimes = generateApachePrimes(100_000);
        assertTrue(apachePrimes.containsAll(jamesPrimes));
        assertTrue(jamesPrimes.containsAll(apachePrimes));
    }


    private Set<Integer> generateApachePrimes(int maxSize) {
        TreeSet<Integer> apachePrimes = new TreeSet<>();
        int i = 2;
        while (apachePrimes.size() < maxSize) {
            i = Primes.nextPrime(i);
            apachePrimes.add(i);
            i++;
        }
        return apachePrimes;
    }
}
