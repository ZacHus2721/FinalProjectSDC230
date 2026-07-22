import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    private Player goku;

    private ArrayList<Mission> missions = new ArrayList<>();

    public Game() {

        goku = new Player("Goku", "Base Form", 9000);

        missions.add(new Mission("Defeat Raditz"));
        missions.add(new Mission("Battle Vegeta"));
        missions.add(new Mission("Stop Frieza"));
    }

    public void start() {

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n===== Dragon Ball Z =====");
            System.out.println("You are playing as Goku!");
            System.out.println();
            System.out.println("1. Start Mission");
            System.out.println("2. View Goku");
            System.out.println("3. View Missions");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    startMission();
                    break;

                case 2:
                    displayGoku();
                    break;

                case 3:
                    displayMissions();
                    break;

                case 4:
                    System.out.println("Thanks for playing!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        input.close();
    }

    private void displayGoku() {

        System.out.println("\n===== Goku =====");
        System.out.println("Name: " + goku.getName());
        System.out.println("Form: " + goku.getForm());
        System.out.println("Power Level: " + goku.getPowerLevel());
    }

    private void displayMissions() {

        System.out.println("\n===== Available Missions =====");

        for (int i = 0; i < missions.size(); i++) {
            System.out.println((i + 1) + ". " + missions.get(i).getMissionName());
        }
    }

    private void startMission() {

        displayMissions();

        System.out.print("\nChoose a mission: ");
        int missionChoice = input.nextInt();
        input.nextLine();

        if (missionChoice >= 1 && missionChoice <= missions.size()) {

            Mission selectedMission = missions.get(missionChoice - 1);

            System.out.println();
            System.out.println("Goku powers up!");
            System.out.println("Mission Started: " + selectedMission.getMissionName());
            System.out.println("To be continued...");
        } else {
            System.out.println("Invalid mission.");
        }
    }

}