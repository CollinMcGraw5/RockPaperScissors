import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerA;
        String playerB;
        String playAgain;

        do {
            do {
                System.out.println("Player A, enter your move (R, P, S): ");
                playerA = scanner.next().toUpperCase();
            } while (!isValidMove(playerA));

            do {
                System.out.println("Player B, enter your move (R, P, S): ");
                playerB = scanner.next().toUpperCase();
            } while (!isValidMove(playerB));

            displayResult(playerA, playerB);

            System.out.println("Do you want to play again? (Y/N): ");
            playAgain = scanner.next().toUpperCase();
        } while (playAgain.equals("Y"));

        scanner.close();
    }

    private static boolean isValidMove(String move) {
        return move.equals("R") || move.equals("P") || move.equals("S");
    }

    private static void displayResult(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            System.out.println(playerA + " vs " + playerB + " it's a Tie!");
        } else if ((playerA.equals("R") && playerB.equals("S")) ||
                (playerA.equals("P") && playerB.equals("R")) ||
                (playerA.equals("S") && playerB.equals("P"))) {
            System.out.println("Player A wins! " + getOutcomePhrase(playerA, playerB));
        } else {
            System.out.println("Player B wins! " + getOutcomePhrase(playerB, playerA));
        }
    }

    private static String getOutcomePhrase(String winner, String loser) {
        if (winner.equals("R") && loser.equals("S")) {
            return "Rock breaks Scissors";
        } else if (winner.equals("P") && loser.equals("R")) {
            return "Paper covers Rock";
        } else if (winner.equals("S") && loser.equals("P")) {
            return "Scissors cuts Paper";
        }
        return "";
    }
}
