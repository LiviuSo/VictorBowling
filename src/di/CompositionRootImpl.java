package di;

import data.FrameFactory;
import data.RankingFactory;
import game.BoardConsoleImpl;
import game.BoardDisplayImpl;
import game.BoardImpl;
import game.ScoreCalculatorImpl;
import game.interf.Board;
import game.interf.BoardConsole;
import game.interf.BoardDisplay;
import game.interf.ScoreCalculator;
import player.PlayerFactory;
import player.RandomGenerator;

import java.util.Scanner;

public class CompositionRootImpl extends CompositionRootBaseImpl {

    public CompositionRootImpl(int noOfFrames, int noOfPins) {
        super(noOfFrames, noOfPins);
    }

    @Override
    public ScoreCalculator provideScoreCalculator() {
        return new ScoreCalculatorImpl(noOfPins);
    }

    @Override
    public Scanner provideScanner() {
        return new Scanner(System.in);
    }

    @Override
    public BoardConsole provideBoardConsole() {
        return new BoardConsoleImpl(scanner);
    }

    @Override
    public RankingFactory provideRankingFactory() {
        return new RankingFactory();
    }

    @Override
    public BoardDisplay provideBoardDisplay() {
        return new BoardDisplayImpl(rankingFactory);
    }

    @Override
    public Board provideBoard() {
        return new BoardImpl(scoreCalculator, boardDisplay, boardConsole);
    }

    @Override
    public RandomGenerator provideRandomGenerator() {
        return new RandomGenerator();
    }

    @Override
    public PlayerFactory providePlayerFactory() {
        return new PlayerFactory(randomGenerator);
    }

    @Override
    public FrameFactory provideFrameFactory() {
        return new FrameFactory();
    }

}
