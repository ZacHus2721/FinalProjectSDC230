import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    private ArrayList<Player> players = new ArrayList<Player>();

    private ArrayList<Mission> missions = new ArrayList<Mission>();

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

            System.out.println();
            System.out.println("===== Dragon Ball Z =====");
            System.out.println("1. Start Mission");
            System.out.println("2. View Goku Stats");
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

        System.out.println();
        System.out.println("===== Goku Stats =====");

        for (Player player : players) {

            System.out.println("Name: " + player.getName());
            System.out.println("Form: " + player.getForm());
            System.out.println("Power Level: " + player.getPowerLevel());
            System.out.println("Level: " + player.getLevel());
            System.out.println("XP: " + player.getExperience());

            player.specialMove();

            System.out.println();

        }

    }

    private void displayMissions() {

        System.out.println();
        System.out.println("===== Missions =====");

        for (int i = 0; i < missions.size(); i++) {

            System.out.println((i + 1) + ". " + missions.get(i).getMissionName());

        }

    }

    private void startMission() {

        displayMissions();

        System.out.print("\nChoose a mission: ");

        int choice = input.nextInt();
        input.nextLine();

        if (choice < 1 || choice > missions.size()) {

            System.out.println("Invalid mission.");
            return;

        }

        Mission mission = missions.get(choice - 1);

        System.out.println();
        System.out.println("Mission Started!");
        System.out.println(mission.getMissionName());
        System.out.println();

        int xpEarned = 50;

        switch (choice) {

        case 1:
            xpEarned = 50;
            break;

        case 2:
            xpEarned = 75;
            break;

        case 3:
            xpEarned = 100;
            break;

        }

        for (Player player : players) {

            player.specialMove();

            player.gainExperience(xpEarned);

            System.out.println(player.getName() + " gained " + xpEarned + " XP.");
            System.out.println();

        }

    }

}