package test.game;

import game.interf.Game;

public class GameEmptyImpl implements Game {

    @Override
    public void setUpGame() {
    }

    @Override
    public void playGame() {
    }

    @Override
    public void showWinner() {
    }

    @Override
    public void endGame() {
    }

    @Override
    public void play() {
    }

    @Override
    public boolean askNewGame() {
        return false;
    }
}
