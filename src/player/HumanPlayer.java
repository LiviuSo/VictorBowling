package player;

import java.util.Scanner;

public class HumanPlayer extends Player {

    static boolean _debug = false;

    public HumanPlayer(String name, RandomGenerator randomGenerator) {
        super(name, randomGenerator);
    }

    public static void setDubug(boolean b) {
        _debug = b;
    }

    @Override
    public int roll(int maxPinsToKnockDown) {
        if(!_debug) { // reflexion instead?
            simulateRollAction();
        }
        return randomGenerator.getRandomInt(maxPinsToKnockDown);
    }

    private void simulateRollAction() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine());
        scanner.nextLine();
    }

}