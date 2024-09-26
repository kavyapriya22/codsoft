import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random(); // random number generator
        Scanner scanner = new Scanner(System.in);
        int totalPoints = 0;
        System.out.print("Your good name please: ");
        String name = scanner.nextLine();
        System.out.println("Welcome to the Number Guessing Game " + name + "!");
        System.out.println("I will think of a number between 1 and 100. You wanna try guessing it?");
        String a = scanner.nextLine();
        if (a.startsWith("Yes")) {
            System.out.println("Let's start!");
        } else {
            System.out.println("That's sad! Exiting...");
            System.exit(0);
        }
        System.out.println("Remember, you have 10 tries to guess the correct number.");
        System.out.println("Press Enter to start the game.");
        scanner.nextLine(); // to consume newline character before next input
        System.out.println("How many rounds do you want to play? (1-10):");
        int rounds = scanner.nextInt(); // Number of rounds

        for (int i = 1; i <= rounds; i++) {
            int numberToGuess = rand.nextInt(100);
            int numberOfTries = 0;
            boolean win = false;

            System.out.println("Round " + i + ":");
            while (win == false) {
                System.out.println("Guess a number between 1 and 100:");
                int guess = scanner.nextInt();
                numberOfTries++;

                if (guess == numberToGuess) {
                    win = true;
                    System.out.println("Congratulations! You found the number in " + numberOfTries + " tries.");
                    totalPoints += 10 - numberOfTries; // Points calculation
                    System.out.println("Points earned: " + (10 - numberOfTries));
                } else if (guess < numberToGuess) {
                    System.out.println("Your guess is too low");
                } else if (guess > numberToGuess) {
                    System.out.println("Your guess is too high");
                }
            }
        }

        System.out.println("Game over! Total points: " + totalPoints);
        if (totalPoints > 0) {
            System.out.println("Congratulations! You have won the game.");
        } else {
            System.out.println("Sorry, try again next time.");
        }
        scanner.close();
    }
}
