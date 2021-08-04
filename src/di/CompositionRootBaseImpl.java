package di;

import data.FrameFactory;
import data.RankingFactory;
import di.interf.CompositionRoot;
import game.interf.Board;
import game.interf.BoardConsole;
import game.interf.BoardDisplay;
import game.interf.ScoreCalculator;
import player.PlayerFactory;
import player.RandomGenerator;

import java.util.Scanner;

public class CompositionRootBaseImpl implements CompositionRoot {

    protected final int noOfFrames;
    protected final int noOfPins;
    protected final ScoreCalculator scoreCalculator;
    protected final Scanner scanner;
    protected final BoardConsole boardConsole;
    protected RankingFactory rankingFactory;
    protected final BoardDisplay boardDisplay;
    protected final Board board;
    protected final RandomGenerator randomGenerator;
    protected final PlayerFactory playerFactory;
    protected final FrameFactory frameFactory;

    public CompositionRootBaseImpl(int noOfFrames, int noOfPins) {
        this.noOfFrames = noOfFrames;
        this.noOfPins = noOfPins;
        this.scoreCalculator = provideScoreCalculator();
        this.scanner = provideScanner();
        this.boardConsole = provideBoardConsole();
        this.rankingFactory = provideRankingFactory();
        this.boardDisplay = provideBoardDisplay();
        this.board = provideBoard();
        this.randomGenerator = provideRandomGenerator();
        this.playerFactory = providePlayerFactory();
        this.frameFactory = provideFrameFactory();
    }

    public int getNoOfFrame() {
        return noOfFrames;
    }

    public int getNoOfPins() {
        return noOfPins;
    }

    @Override
    public ScoreCalculator provideScoreCalculator() {
        return null;
    }

    @Override
    public Scanner provideScanner() {
        return null;
    }

    @Override
    public BoardConsole provideBoardConsole() {
        return null;
    }

    @Override
    public RankingFactory provideRankingFactory() {
        return null;
    }

    @Override
    public BoardDisplay provideBoardDisplay() {
        return null;
    }

    @Override
    public Board provideBoard() {
        return null;
    }

    @Override
    public RandomGenerator provideRandomGenerator() {
        return null;
    }

    @Override
    public PlayerFactory providePlayerFactory() {
        return null;
    }

    @Override
    public FrameFactory provideFrameFactory() {
        return null;
    }

    public PlayerFactory getPlayerFactory() {
        return playerFactory;
    }

    public FrameFactory getFrameFactory() {
        return frameFactory;
    }

    public Board getBoard() {
        return board;
    }

//    public <T> Object provide(Class<T> type) {
//        if (ScoreCalculator.class.equals(type)) {
//            return scoreCalculator;
//        } else if (Scanner.class.equals(type)) {
//            return scanner;
//        } else if (BoardConsole.class.equals(type)) {
//            return boardConsole;
//        } else if (BoardDisplay.class.equals(type)) {
//            return boardDisplay;
//        } else if (Board.class.equals(type)) {
//            return board;
//        } else if (RandomGenerator.class.equals(type)) {
//            return randomGenerator;
//        } else if (PlayerFactory.class.equals(type)) {
//            return playerFactory;
//        } else if (FrameFactory.class.equals(type)) {
//            return frameFactory;
//        }
//        return null;
//    }
}
