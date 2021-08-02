public abstract class Player {

    private String name;
    protected final RandomGenerator randomGenerator = new RandomGenerator();

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int roll(int maxPinsToKnockDown);
}
