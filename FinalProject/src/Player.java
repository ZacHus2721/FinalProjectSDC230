public class Player {

    private String name;
    private String form;
    private int powerLevel;

    public Player(String name, String form, int powerLevel) {
        this.name = name;
        this.form = form;
        this.powerLevel = powerLevel;
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

    public void specialMove() {
        System.out.println(name + " throws a punch.");
    }
}