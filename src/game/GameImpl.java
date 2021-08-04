package game;

import data.Frame;
import data.FrameFactory;
import data.Frames;
import data.Roll;
import di.CompositionRootImpl;
import game.interf.Board;
import game.interf.Game;
import player.*;

import java.util.InputMismatchException;

public class GameImpl implements Game {
    private final int noOfFrames;
    private final int noOfPins;
    private int noOfPlayers;
    private Player[] players;
    private Frames[] frames;
    private final Board board;
    private final PlayerFactory playerFactory;
    private final FrameFactory frameFactory;

    public GameImpl(CompositionRootImpl compositionRoot) {
        this.noOfFrames = compositionRoot.getNoOfFrame();
        this.noOfPins = compositionRoot.getNoOfPins();
        this.noOfPlayers = 0;
        this.players = null;
        this.frames = null;
        this.board = compositionRoot.getBoard();
        this.playerFactory = compositionRoot.getPlayerFactory();
        this.frameFactory = compositionRoot.getFrameFactory();
    }

    public void play() {
        do {
            try {
                setUpGame();
                playGame();
                showWinner();
            } catch (InputMismatchException e) {
                board.showError("Invalid input.");
            } finally {
                endGame();
            }
        } while (askNewGame());
    }

    @Override
    public void setUpGame() {
        askNumberOfPlayers();
        initPlayers();
        initFrames();
    }

    @Override
    public void playGame() {
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

    @Override
    public void endGame() {
        AutoPlayer.resetInstanceCount();
    }

    @Override
    public void showWinner() {
        board.showRanking(players, frames);
    }

    @Override
    public boolean askNewGame() {
        board.showQuestionNewGame();
        String answer = board.enterConfirmationNewGame();
        return answer.equals("y");
    }

    private void initPlayers() {
        players = new Player[noOfPlayers];
        for (int i = 0; i < noOfPlayers; i++) {
            board.showInviteToEnterPlayerType();
            String type = board.enterPlayerType();
            if (type.equals("y")) {
                players[i] = playerFactory.getAutoPlayer();
            } else {
                board.showInviteToEnterPlayerName(i + 1);
                String name = board.enterPlayerName();
                players[i] = playerFactory.getHumanPlayer(name);
            }
        }
    }

    private void initFrames() {
        this.frames = new Frames[noOfPlayers];
        for (int i = 0; i < noOfPlayers; i++) {
            frames[i] = frameFactory.getFrames(noOfFrames, noOfPins);
        }
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
