import java.util.Scanner;

public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public int roll(int maxPinsToKnockDown) {
        Scanner intReader = new Scanner( System.in );
        return intReader.nextInt();
    }

    public String getName() {
        return name;
    }

}
