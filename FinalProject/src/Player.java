public class Player {

    private String name;
    private String form;
    private int powerLevel;
    private int level;
    private int experience;

    public Player(String name, String form, int powerLevel) {

        this.name = name;
        this.form = form;
        this.powerLevel = powerLevel;

        level = 1;
        experience = 0;
    }

    public String getName() {
        return name;
    }

    public String getForm() {
        return form;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void gainExperience(int xp) {

        experience += xp;

        while (experience >= 100) {

            experience -= 100;
            level++;

            System.out.println(name + " leveled up!");
        }
    }

    public void specialMove() {

        System.out.println(name + " attacks!");

    }

}