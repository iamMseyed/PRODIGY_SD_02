package prodigy;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("""
    							====WELCOME TO THE GUESSING GAME===\n
    					THIS IS A CUSTOM GUESSING GAME WHERE USER CAN MANUALLY SET A LIMT!\n
    			Enter starting point of the range you want to set (e.g 0 or 10 or 100... or whatever you want):""");

        while (true) {
            try {
            	int minNumber = scanner.nextInt();
            	System.out.print("Similarly enter ending point of the range:");
                int maxNumber = scanner.nextInt();
                
                int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
                int attempts = 0;
                int guess;
                System.out.println("""
                		Superb! System has automatically chosen a number between %d - %d. Can you guess it?""".formatted(minNumber, maxNumber));
                guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low! Try again. System guess was: "+randomNumber);
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.System guess was: "+randomNumber);
                } else {
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly.");
                    System.out.println("It took you " + attempts + " attempts to win the game.");
                    break;
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}

