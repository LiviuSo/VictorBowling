import game.interf.Game;
import game.GameImpl;

public class Launcher {
    static int noOfFrames = 10;
    static int noOfPins = 10;

    public static void main(String[] args) {
        Game game = new GameImpl(noOfFrames, noOfPins);
        game.play();
    }
}
