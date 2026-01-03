import java.util.Random;
import java.util.Scanner;

/**
 * Number Guessing Game
 *
 * Features:
 * - Computer picks a random number in a range (default 1–100)
 * - Player guesses and gets feedback: higher / lower / correct
 * - Limited attempts per round
 * - Multiple rounds
 * - Scoring based on how quickly you guess the number
 */
public class NumberGuessingGame {

    // Game configuration constants
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS_PER_ROUND = 7;
    private static final int TOTAL_ROUNDS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=======================================");
        System.out.println("        WELCOME TO GUESS THE NUMBER    ");
        System.out.println("=======================================");
        System.out.println("Rules:");
        System.out.println("- I will think of a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
        System.out.println("- You have " + MAX_ATTEMPTS_PER_ROUND + " attempts each round to guess it.");
        System.out.println("- There are " + TOTAL_ROUNDS + " rounds in total.");
        System.out.println("- The fewer attempts you use, the more points you earn.");
        System.out.println();

        boolean keepPlaying = true;

        while (keepPlaying) {
            int totalScore = 0;

            for (int round = 1; round <= TOTAL_ROUNDS; round++) {
                System.out.println("---------------------------------------");
                System.out.println("Round " + round + " of " + TOTAL_ROUNDS);
                System.out.println("---------------------------------------");

                int secretNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
                int attemptsUsed = 0;
                boolean guessedCorrectly = false;

                while (attemptsUsed < MAX_ATTEMPTS_PER_ROUND && !guessedCorrectly) {
                    System.out.print("Enter your guess (" + MIN_NUMBER + " - " + MAX_NUMBER + "): ");
                    int guess = readInt(scanner);

                    // Validate range
                    if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                        System.out.println("Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                        continue;
                    }

                    attemptsUsed++;

                    if (guess == secretNumber) {
                        guessedCorrectly = true;
                        int points = calculatePoints(attemptsUsed);
                        totalScore += points;
                        System.out.println("Correct! You guessed the number in " + attemptsUsed + " attempt(s).");
                        System.out.println("You earned " + points + " point(s) this round.");
                    } else if (guess < secretNumber) {
                        System.out.println("Too low! Try a higher number.");
                    } else {
                        System.out.println("Too high! Try a lower number.");
                    }

                    if (!guessedCorrectly && attemptsUsed == MAX_ATTEMPTS_PER_ROUND) {
                        System.out.println("Out of attempts! The correct number was: " + secretNumber);
                    }
                }

                System.out.println("Your current total score: " + totalScore);
                System.out.println();
            }

            System.out.println("=======================================");
            System.out.println("              GAME OVER                ");
            System.out.println("=======================================");
            System.out.println("Your final score after " + TOTAL_ROUNDS + " round(s): " + totalScore);
            System.out.println();

            System.out.print("Do you want to play again? (Y/N): ");
            String answer = scanner.next().trim().toUpperCase();
            keepPlaying = answer.equals("Y");
            System.out.println();
        }

        System.out.println("Thank you for playing the Number Guessing Game!");
        scanner.close();
    }

    /**
     * Calculates points based on how quickly the user guessed the number.
     * Fewer attempts yield more points.
     *
     * Example scoring:
     * - 1st attempt: 100 points
     * - 2nd attempt: 80 points
     * - 3rd attempt: 60 points
     * - 4th attempt: 40 points
     * - 5th attempt: 30 points
     * - 6th attempt: 20 points
     * - 7th attempt (or last): 10 points
     */
    private static int calculatePoints(int attemptsUsed) {
        switch (attemptsUsed) {
            case 1:
                return 100;
            case 2:
                return 80;
            case 3:
                return 60;
            case 4:
                return 40;
            case 5:
                return 30;
            case 6:
                return 20;
            default:
                return 10;
        }
    }

    /**
     * Safely reads an integer from the scanner, re-prompting if input is invalid.
     */
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a whole number: ");
            scanner.next(); // discard invalid token
        }
        return scanner.nextInt();
    }
}



