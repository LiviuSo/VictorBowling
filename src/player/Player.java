package player;

public abstract class Player {

    private String name;
    protected RandomGenerator randomGenerator;

    public Player(String name, RandomGenerator randomGenerator) {
        this.name = name;
        this.randomGenerator = randomGenerator;
    }

    public Player(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int roll(int maxPinsToKnockDown);
}
