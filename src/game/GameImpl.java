package game;

import data.Frame;
import data.Frames;
import data.Roll;
import game.interf.Game;
import game.interf.ScoreCalculator;
import player.AutoPlayer;
import player.HumanPlayer;
import player.Player;

import java.util.InputMismatchException;

public class GameImpl implements Game {
    private final int noOfFrames;
    private final int noOfPins;
    private int noOfPlayers;
    private Player[] players;
    private Frames[] frames;
    private final BoardImpl board;

    public GameImpl(int noOfFrames, int noOfPins) {
        this.noOfFrames = noOfFrames;
        this.noOfPins = noOfPins;
        this.noOfPlayers = 0;
        this.players = null;
        this.frames = null;
        ScoreCalculator scoreCalculator = new ScoreCalculatorImpl(noOfPins);
        this.board = new BoardImpl(scoreCalculator);
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

    private void initPlayers() {
        players = new Player[noOfPlayers];
        for (int i = 0; i < noOfPlayers; i++) {
            board.showInviteToEnterPlayerType();
            String type = board.enterPlayerType();
            if (type.equals("y")) {
                players[i] = new AutoPlayer();
            } else {
                board.showInviteToEnterPlayerName(i + 1);
                String name = board.enterPlayerName();
                players[i] = new HumanPlayer(name);
            }
        }
    }

    private void initFrames() {
        this.frames = new Frames[noOfPlayers];
        for (int i = 0; i < noOfPlayers; i++) {
            frames[i] = new Frames(noOfFrames, noOfPins);
        }
    }

    private void endGame() {
        AutoPlayer.resetInstanceCount();
    }

    private void showWinner() {
        board.showRanking(players, frames);
    }

    private void setUpGame() {
        askNumberOfPlayers();
        initPlayers();
        initFrames();
    }

    private void askNumberOfPlayers() {
        do {
            board.showInviteNumberOfPlayers();
            int noOfPlayers = board.enterNumberOfPlayers();
            if (noOfPlayers == 2 || noOfPlayers == 3 || noOfPlayers == 4) {
                this.noOfPlayers = noOfPlayers;
                break;
            } else {
                board.showError("Invalid option.");
            }
        } while (true);
    }

    private boolean askNewGame() {
        board.showQuestionNewGame();
        String answer = board.enterConfirmationNewGame();
        return answer.equals("y");
    }

    private void playGame() {
        try {
            board.showStartMessage();
            for (int frameIndex = 0; frameIndex < noOfFrames; ++frameIndex) {
                playFrame(frameIndex);
            }
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
            board.showError(e.getMessage());
        } finally {
            board.showEndMessage();
        }
    }

    private void playFrame(int frameIndex) {
        board.showFrameHeader(frameIndex + 1);
        for (int playerIndex = 0; playerIndex < noOfPlayers; playerIndex++) {
            Player player = players[playerIndex];
            Frames playerFrames = frames[playerIndex];
            board.showPlayerHeader(player);
            boolean cont = roll(player, playerFrames, frameIndex, Roll.FIRST);
            if (cont) {
                cont = roll(player, playerFrames, frameIndex, Roll.SECOND);
                if (cont) {
                    roll(player, playerFrames, frameIndex, Roll.THIRD);
                }
            }
        }
    }

    private boolean roll(Player player, Frames frames, int frameIndex, Roll roll) {
        Frame frame = frames.getFrameAt(frameIndex);
        int maxPins = frame.getPinsLeftAfterFirstRoll();
        if (roll == Roll.THIRD || (roll == Roll.SECOND && frame.isLast() && frame.isStrike())) {
            maxPins = noOfPins; // for the third roll or the second  roll in the last frame after a strike,
                                // we have the max number of pins
        }
        boolean isHuman = player.getClass() == HumanPlayer.class;
        if (isHuman) {
            board.showInviteToRoll(maxPins);
        }
        int pinsKnockedDown = player.roll(maxPins);
        board.showNumberOfPinsKnockedDown(pinsKnockedDown, isHuman);
        return board.updateFrameGrid(frames, frameIndex, pinsKnockedDown, roll);
    }

}
