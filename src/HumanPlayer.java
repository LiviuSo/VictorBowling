import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int roll(int maxPinsToKnockDown) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine());
        scanner.nextLine();
        return randomGenerator.getRandomInt(maxPinsToKnockDown);
    }

}