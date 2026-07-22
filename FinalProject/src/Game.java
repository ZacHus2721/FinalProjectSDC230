import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Mission> missions = new ArrayList<Mission>();

    public Game() {

        players.add(new BaseGoku());
        players.add(new SuperSaiyanGoku());

        missions.add(new Mission("Defeat Raditz",
                new Enemy("Raditz", 50), 50));

        missions.add(new Mission("Battle Vegeta",
                new Enemy("Vegeta", 80), 75));

        missions.add(new Mission("Stop Frieza",
                new Enemy("Frieza", 120), 100));

    }

    public void start() {

        int choice = 0;

        while (choice != 5) {

            System.out.println();
            System.out.println("===== Dragon Ball Z =====");
            System.out.println("1. Start Mission");
            System.out.println("2. View Goku Stats");
            System.out.println("3. View Missions");
            System.out.println("4. Heal Goku");
            System.out.println("5. Exit");
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
                healPlayers();
                break;

            case 5:
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
            System.out.println("Health: " + player.getHealth());
            System.out.println("Level: " + player.getLevel());
            System.out.println("XP: " + player.getExperience());

            System.out.println();

        }

    }

    private void displayMissions() {

        System.out.println();
        System.out.println("===== Missions =====");

        for (int i = 0; i < missions.size(); i++) {

            Mission mission = missions.get(i);

            System.out.println((i + 1) + ". "
                    + mission.getMissionName());

            System.out.println("Enemy: "
                    + mission.getEnemy().getName());

            System.out.println("XP Reward: "
                    + mission.getXpReward());

            System.out.println();

        }

    }

    private void healPlayers() {

        for (Player player : players) {

            player.heal();

        }

        System.out.println("Goku has fully recovered!");

    }

    private void startMission() {

        displayMissions();

        System.out.print("Choose a mission: ");

        int missionChoice = input.nextInt();
        input.nextLine();

        if (missionChoice < 1 || missionChoice > missions.size()) {

            System.out.println("Invalid mission.");
            return;

        }

        Mission mission = missions.get(missionChoice - 1);

        Enemy enemy = mission.getEnemy();

        System.out.println();
        System.out.println("Mission Started!");
        System.out.println(mission.getMissionName());

        System.out.println();
        System.out.println("Enemy: " + enemy.getName());

        while (enemy.getHealth() > 0) {

            for (Player player : players) {

                player.specialMove();

                enemy.takeDamage(40);

                System.out.println(enemy.getName()
                        + " has "
                        + enemy.getHealth()
                        + " health remaining.");

                if (enemy.getHealth() <= 0) {

                    break;

                }

                player.takeDamage(20);

                System.out.println(player.getName()
                        + " loses 20 health.");

                System.out.println(player.getName()
                        + " Health: "
                        + player.getHealth());

                System.out.println();

            }

        }

        System.out.println();
        System.out.println(enemy.getName() + " was defeated!");

        for (Player player : players) {

            player.gainExperience(mission.getXpReward());

            System.out.println(player.getName()
                    + " earned "
                    + mission.getXpReward()
                    + " XP.");

        }

    }

}