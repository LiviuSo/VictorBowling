public class Launcher {
    static int noOfFrames = 10;
    static int noOfPins = 10;

    public static void main(String[] args) {
        Game game = new Game(noOfFrames, noOfPins);
        game.play();
    }
}
