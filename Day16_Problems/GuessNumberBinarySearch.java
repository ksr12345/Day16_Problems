import java.util.Scanner;

public class GuessNumberBinarySearch {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GuessNumberBinarySearch <N>");
            return;
        }

        try {
            int N = Integer.parseInt(args[0]);
            int numQuestions = (int) (Math.log(N) / Math.log(2)); // Calculate number of questions needed

            System.out.println("Think of a number between 0 and " + (N - 1));
            int guess = guessNumber(0, N - 1, numQuestions);
            System.out.println("The number you thought of is: " + guess);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for N. Please enter a valid integer.");
        }
    }

    // Recursive method to guess the number using binary search
    public static int guessNumber(int low, int high, int questionsLeft) {
        Scanner scanner = new Scanner(System.in);
        int mid = (low + high) / 2;

        if (questionsLeft == 0) {
            return mid; // We've made n questions, return the current guess
        }

        System.out.println("Is the number between " + low + " and " + mid + "? (true/false)");
        boolean isBetween = scanner.nextBoolean();

        if (isBetween) {
            // Number is between low and mid
            return guessNumber(low, mid, questionsLeft - 1);
        } else {
            // Number is between mid + 1 and high
            return guessNumber(mid + 1, high, questionsLeft - 1);
        }
    }
}

