import java.util.Scanner;
import java.util.Random;

public class BlackJackGame {
    static Random myRan = new Random();
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {

        int computerWins = 0;
        int userWins = 0;
        String winner;
        String playAgain;

        winner = playBlackJack();
        do{
            if (winner.equalsIgnoreCase("Computer won!")) {
                computerWins ++;
            }
            else if (winner.equalsIgnoreCase("User won!")) {
                userWins ++;
            }
            System.out.println("Do you want to play again?");
            playAgain = keyboard.nextLine();
        } while (playAgain.equalsIgnoreCase("Yes"));

        System.out.println("User won " + userWins + " times.");
        System.out.println("Computer won " + computerWins + " times.");

    }
    public static String playBlackJack() {
        int userCardTotal = 0;
        int computerCardTotal = 0;
        int userRandomCardValue = 0;
        int computerRandomCardValue = 0;
        String userStop = "";

        do {
            userRandomCardValue = myRan.nextInt(0, 12);
            userCardTotal = userCardTotal + userRandomCardValue;

            computerRandomCardValue = myRan.nextInt(0, 12);
            computerCardTotal = computerCardTotal + computerRandomCardValue;

            System.out.println("The user drew: " + userRandomCardValue);
            System.out.println("User got: " + userCardTotal + " points.");

            System.out.println("The computer drew: " + computerRandomCardValue);
            System.out.println("Computer got: " + computerCardTotal + " points.");

            System.out.println("Do you want another card?");
            userStop = keyboard.nextLine();

        } while (userCardTotal < 21 && computerCardTotal < 21 && userStop.equalsIgnoreCase("YES"));

        if (userCardTotal == 21 && computerCardTotal == 21) {

            return "It's a tie!";
        }
        else if (computerCardTotal == 21) {
            return "Computer won!";
        }
        else if (userCardTotal == 21) {
            return "User won!";
        }
        else if (userCardTotal > 21 && computerCardTotal > 21) {
            return "Both lost";
        }
        else if (userCardTotal > 21 && computerCardTotal < 21) {
            return "Computer won!";
        }
        else if ((userCardTotal < 21) && computerCardTotal >  21) {
            return "User won!";
        }
        else if ((computerCardTotal < userCardTotal)) {
            return "Computer won!";
        }
        else {
            return "Tie!";
        }

    }
}
