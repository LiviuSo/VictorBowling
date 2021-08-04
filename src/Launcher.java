import di.CompositionRootImpl;
import game.interf.Game;
import game.GameImpl;

public class Launcher {
    static int noOfFrames = 10;
    static int noOfPins = 10;

    public static void main(String[] args) {
        if(args.length  == 2) {
            noOfFrames =  Integer.parseInt(args[0]);
            noOfPins =  Integer.parseInt(args[1]);
        } else if(args.length == 1) {
            noOfFrames =  Integer.parseInt(args[0]);
        }

        CompositionRootImpl compositionRoot = new CompositionRootImpl(noOfFrames, noOfPins);
        Game game = new GameImpl(compositionRoot);
        game.play();
    }
}
