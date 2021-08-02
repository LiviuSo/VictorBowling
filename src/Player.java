import java.util.Scanner;

public class Player {

    private String name;
    private final RandomGenerator randomGenerator = new RandomGenerator();

    public Player(String name) {
        this.name = name;
    }

    public int roll(int maxPinsToKnockDown) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine()) ; // wait for enter
        scanner.nextLine();
        return randomGenerator.getRandomInt(maxPinsToKnockDown);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
