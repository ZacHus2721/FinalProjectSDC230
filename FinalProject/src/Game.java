import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Mission> missions = new ArrayList<>();

    public Game() {

        players.add(new BaseGoku());
        players.add(new SuperSaiyanGoku());
    

        missions.add(new Mission("Defeat Raditz"));
        missions.add(new Mission("Battle Vegeta"));
        missions.add(new Mission("Stop Frieza"));
    }

    public void start() {

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n===== Dragon Ball Z =====");
            System.out.println("1. Start Mission");
            System.out.println("2. View Goku Forms");
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
                    displayPlayers();
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

    private void displayPlayers() {

        System.out.println("\n===== Goku Forms =====");

        for (Player player : players) {

            System.out.println(player.getName());
            System.out.println(player.getForm());
            System.out.println("Power Level: " + player.getPowerLevel());

            player.specialMove();

            System.out.println();
        }
    }

    private void displayMissions() {

        System.out.println("\n===== Missions =====");

        for (Mission mission : missions) {
            System.out.println(mission.getMissionName());
        }
    }

    private void startMission() {

        displayMissions();

        System.out.print("\nChoose a mission: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice >= 1 && choice <= missions.size()) {

            System.out.println();
            System.out.println("Mission Started!");
            System.out.println(missions.get(choice - 1).getMissionName());

            System.out.println("\nEvery version of Goku prepares for battle!");

            for (Player player : players) {
                player.specialMove();
            }

        } else {

            System.out.println("Invalid mission.");
        }
    }
}