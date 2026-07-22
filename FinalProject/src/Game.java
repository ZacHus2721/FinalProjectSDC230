import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start() {
        int choice = 0;

        while (choice != 3) {
            System.out.println("\n=== Adventure Game ===");
            System.out.println("1. Start Game");
            System.out.println("2. View Character");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            if (choice == 1) {
                System.out.println("The adventure begins!");
            } else if (choice == 2) {
                System.out.println("Character information coming soon.");
            } else if (choice == 3) {
                System.out.println("Thanks for playing!");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}