package game;

import data.Frames;
import data.Roll;
import exception.ExceptionTool;
import game.interf.Board;
import game.interf.BoardConsole;
import game.interf.BoardDisplay;
import game.interf.ScoreCalculator;
import player.Player;

public class BoardImpl implements Board {
    private final BoardDisplay boardDisplay;
    private final BoardConsole boardConsole;
    private final ScoreCalculator scoreCalculator;

    public BoardImpl(ScoreCalculator scoreCalculator, BoardDisplay boardDisplay, BoardConsole boardConsole) {
        this.scoreCalculator = scoreCalculator; // todo inject
        this.boardDisplay = boardDisplay; // todo  inject
        this.boardConsole = boardConsole; // todo inject
    }

    @Override
    public boolean updateFrameGrid(Frames frames, int frameIndex, int pinsKnockedDown, Roll roll) {
        ExceptionTool.checkIndex(frameIndex, frames.getNoOfFrames());

        // add the rolls
        boolean continueToRoll = scoreCalculator.updateRolls(frames, frameIndex, pinsKnockedDown, roll);
        // update the totals
        if (!continueToRoll) {
            scoreCalculator.updateTotals(frames, frameIndex);
            scoreCalculator.updateScores(frames, frameIndex);
        }
        // show grid
        boardDisplay.showFrames(frames);

        return continueToRoll;
    }

    @Override
    public void showInviteToEnterPlayerType() {
        boardDisplay.showInviteToEnterPlayerType();
    }

    @Override
    public void showInviteToEnterPlayerName(int i) {
        boardDisplay.showInviteToEnterPlayerName(i);
    }

    @Override
    public void showQuestionNewGame() {
        boardDisplay.showQuestionNewGame();
    }

    @Override
    public void showRanking(Player[] players, Frames[] frames) {
        boardDisplay.showRanking(players, frames);
    }

    @Override
    public void showInviteNumberOfPlayers() {
        boardDisplay.showInviteNumberOfPlayers();
    }

    @Override
    public void showError(String s) {
        boardDisplay.showError(s);
    }

    @Override
    public void showStartMessage() {
        boardDisplay.showStartMessage();
    }

    @Override
    public void showEndMessage() {
        boardDisplay.showEndMessage();
    }

    @Override
    public void showFrameHeader(int i) {
        boardDisplay.showFrameHeader(i);
    }

    @Override
    public void showPlayerHeader(Player player) {
        boardDisplay.showPlayerHeader(player);
    }

    @Override
    public void showInviteToRoll(int maxPins) {
        boardDisplay.showInviteToRoll(maxPins);
    }

    @Override
    public void showNumberOfPinsKnockedDown(int pinsKnockedDown, boolean isHuman) {
        boardDisplay.showNumberOfPinsKnockedDown(pinsKnockedDown, isHuman);
    }

    @Override
    public String enterPlayerType() {
        return boardConsole.enterPlayerType();
    }

    @Override
    public String enterPlayerName() {
        return boardConsole.enterPlayerName();
    }

    @Override
    public int enterNumberOfPlayers() {
        return boardConsole.enterNumberOfPlayers();
    }

    @Override
    public String enterConfirmationNewGame() {
        return boardConsole.enterConfirmationNewGame();
    }

}
