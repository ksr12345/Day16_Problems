import java.util.*;

public class PrimeNumbers {

    public static List<Integer> findPrimes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true); // Assume all numbers are prime initially

        for (int p = 2; p * p <= max; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= max; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        int max = 1000;
        List<Integer> primes = findPrimes(max);

        System.out.println("Prime numbers in the range 0 to " + max + ":");
        System.out.println(primes);
    }
}

