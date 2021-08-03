import game.interf.Game;
import game.GameImpl;

public class Launcher {

    public static void main(String[] args) {

        int noOfFrames = 10;
        int noOfPins = 10;

        if(args.length  == 2) {
            noOfFrames =  Integer.parseInt(args[0]);
            noOfPins =  Integer.parseInt(args[1]);
        } else if(args.length == 1) {
            noOfFrames =  Integer.parseInt(args[0]);
        }

        Game game = new GameImpl(noOfFrames, noOfPins);
        game.play();
    }
}
