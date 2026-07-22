public class Player {

    private String name;
    private String form;
    private int powerLevel;
    private int health;
    private int level;
    private int experience;

    public Player(String name, String form, int powerLevel) {

        this.name = name;
        this.form = form;
        this.powerLevel = powerLevel;

        health = 100;
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

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void takeDamage(int damage) {

        health -= damage;

        if (health < 0) {
            health = 0;
        }

    }

    public void heal() {

        health = 100;

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