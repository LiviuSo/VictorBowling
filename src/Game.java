import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private final int noOfFrames;
    private final int noOfPins;
    private int noOfPlayers;
    private Player[] players;
    private Frames[] frames;
    private ScoreCalculator scoreCalculator;
    private final Board board;

    private final Scanner reader = new Scanner(System.in);


    public Game(int noOfFrames, int noOfPins) {
        this.noOfFrames = noOfFrames;
        this.noOfPins = noOfPins;
        this.noOfPlayers = 0;
        this.players = null;
        this.frames = null;
        this.scoreCalculator = new ScoreCalculator(noOfPins);
        this.board = new Board(scoreCalculator);
    }

    private void initPlayers() {
        players = new Player[noOfPlayers];
        for (int i = 0; i < noOfPlayers; i++) {
            board.askPlayerType();
            while (!reader.hasNextLine()) ;
            String type = reader.next();
            if (type.equals("y")) {
                players[i] = new AutoPlayer();
            } else {
                board.invitePlayer(i + 1);
                String name = reader.next();
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

    public void play() {
        do {
            setUpGame();
            playGame();
            showWinner();
        } while (askNewGame());
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
            int noOfPlayers = reader.nextInt();
            if (noOfPlayers == 2 || noOfPlayers == 3 || noOfPlayers == 4) {
                this.noOfPlayers = noOfPlayers;
                break;
            } else {
                board.showError("Invalid option.");
            }
        } while (true);
    }

    private boolean askNewGame() {
        board.askNewGame();
        String answer = reader.next();
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
        if (roll == Roll.THIRD || (roll == Roll.SECOND && frame.isLast())) {
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
