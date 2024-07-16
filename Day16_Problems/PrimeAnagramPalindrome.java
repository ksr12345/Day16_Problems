import java.util.*;

public class PrimeAnagramPalindrome {

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

    public static boolean areAnagrams(int num1, int num2) {
        // Convert integers to strings
        String s1 = Integer.toString(num1);
        String s2 = Integer.toString(num2);

        // Sort characters in both strings
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted strings
        return Arrays.equals(arr1, arr2);
    }

    public static boolean isPalindrome(int num) {
        // Convert integer to string
        String s = Integer.toString(num);

        // Check if string is palindrome
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        int max = 1000;
        List<Integer> primes = findPrimes(max);

        System.out.println("Prime numbers that are also Anagram and Palindrome in the range 0 to " + max + ":");
        for (int prime : primes) {
            if (isPalindrome(prime) && isAnagramPrime(prime, primes)) {
                System.out.println(prime);
            }
        }
    }

    private static boolean isAnagramPrime(int prime, List<Integer> primes) {
        for (int i : primes) {
            if (i != prime && areAnagrams(prime, i)) {
                return true;
            }
        }
        return false;
    }
}




