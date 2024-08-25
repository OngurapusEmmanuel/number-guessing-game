import java.util.Random;
import java.util.Scanner;

public class NumberGuesingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 5; // Limit the number of attempts
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");

                // Input validation
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 100.");
                    scanner.next(); // Clear the invalid input
                }

                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                }

                if (attempts == maxAttempts && !hasGuessedCorrectly) {
                    System.out.println("Sorry! You've used all your attempts. The number was " + numberToGuess + ".");
                }
            }

            System.out.print("Would you like to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
