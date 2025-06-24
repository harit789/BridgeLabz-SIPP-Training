package Built_In_Function.Level_1;
import java.util.*;
public class NumberGuessingGame {
 
    public static void main(String[] args) {
        playGame();
    }

    public static int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    public static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess (1 to 100): ");
        return scanner.nextInt();
    }

    public static void giveFeedback(int guess, int numberToGuess) {
        if (guess < numberToGuess) {
            System.out.println("Too low!");
        } else if (guess > numberToGuess) {
            System.out.println("Too high!");
        } else {
            System.out.println("Correct! You guessed the number.");
        }
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = generateRandomNumber();
        int guess = -1;

        while (guess != numberToGuess) {
            guess = getUserGuess(scanner);
            giveFeedback(guess, numberToGuess);
        }

        scanner.close();
    }

    
}

    
