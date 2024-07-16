import java.util.*;

public class Recursion {
    public static List<String> permutationsIterative(String s) {
        List<String> result = new ArrayList<>();
        result.add(""); // Start with an empty permutation

        for (char c : s.toCharArray()) {
            List<String> newPermutations = new ArrayList<>();
            for (String permutation : result) {
                for (int i = 0; i <= permutation.length(); i++) {
                    String newPermutation = permutation.substring(0, i) + c + permutation.substring(i);
                    newPermutations.add(newPermutation);
                }
            }
            result = newPermutations;
        }

        return result;
    }

    public static List<String> permutationsRecursive(String s) {
        List<String> result2 = new ArrayList<>();
        permutationsHelper("", s, result2);
        return result2;
    }

    private static void permutationsHelper(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {permutationsHelper(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), result);
            }
        }
    }

    public static boolean areEqual(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        return new HashSet<>(list1).containsAll(list2) && new HashSet<>(list2).containsAll(list1);
    }

    public static void main(String[] args) {
        String input = "abc";

        // Generate permutations using iterative method (for comparison)
        List<String> permutationsIter = permutationsIterative(input);
        System.out.println("Iterative Permutations: " + permutationsIter);

        // Generate permutations using recursive method
        List<String> permutationsRec = permutationsRecursive(input);
        System.out.println("Recursive Permutations: " + permutationsRec);

        // Check if both lists are equal
        boolean isEqual = areEqual(permutationsIter, permutationsRec);
        System.out.println("Are the arrays equal? " + isEqual);
    }
}
