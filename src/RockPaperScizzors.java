import java.util.Random;
import java.util.Scanner;

public class RockPaperScizzors {

    // Enum representing the choices in Rock-Paper-Scissors game
    enum Choice {
        ROCK, PAPER, SCIZZORS;

        // Method to determine the winner between two choices
        public int compare(Choice otherChoice) {
            if (this == otherChoice)
                return 0;
            switch (this) {
                case ROCK:
                    return (otherChoice == SCIZZORS) ? 1 : -1;
                case PAPER:
                    return (otherChoice == ROCK) ? 1 : -1;
                case SCIZZORS:
                    return (otherChoice == PAPER) ? 1 : -1;
                default:
                    throw new IllegalArgumentException("Invalid choice");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Enter choice (ROCK, PAPER, SCIZZORS), or 'quit'");
            String userInput = scanner.nextLine().toUpperCase();

            // Check if the user wants to quit the game
            if (userInput.equals("QUIT")) {
                System.out.println("Thanks for playing!");
                break;
            }

            Choice userChoice;
            try {
                userChoice = Choice.valueOf(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice enter ROCK, PAPER, or SCIZZORS.");
                continue;
            }

            // Generate computer's choice
            Choice computerChoice = Choice.values()[random.nextInt(Choice.values().length)];

            // Determine the winner
            int result = userChoice.compare(computerChoice);
            if (result == 0) {
                System.out.println("It's a tie!");
            } else if (result == 1) {
                System.out.println("You win! Computer chose " + computerChoice);
            } else {
                System.out.println("You lose! Computer chose " + computerChoice);
            }
        }

        scanner.close();
    }
}
