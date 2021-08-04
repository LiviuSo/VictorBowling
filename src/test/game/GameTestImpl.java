package test.game;

public class GameTestImpl extends GameEmptyImpl {

    public String setupGameMessage;
    public String playGameMessage;
    public String showWinnerMessage;
    public String ensGameMessage;

    @Override
    public void setUpGame() {
        setupGameMessage = "No of players: 2";
    }

    @Override
    public void playGame() {
        playGameMessage = "Playing...";
    }

    @Override
    public void showWinner() {
        showWinnerMessage = "The winner is: John";
    }

    @Override
    public void endGame() {
        ensGameMessage = "Game over.";
    }

    @Override
    public boolean askNewGame() {
        return false;
    }

    @Override
    public void play() {
        do {
            setUpGame();
            playGame();
            showWinner();
            endGame();
        } while (askNewGame());
    }

}
