public class Mission {

    private String missionName;
    private Enemy enemy;
    private int xpReward;

    public Mission(String missionName, Enemy enemy, int xpReward) {

        this.missionName = missionName;
        this.enemy = enemy;
        this.xpReward = xpReward;

    }

    public String getMissionName() {

        return missionName;

    }

    public Enemy getEnemy() {

        return enemy;

    }

    public int getXpReward() {

        return xpReward;

    }

}