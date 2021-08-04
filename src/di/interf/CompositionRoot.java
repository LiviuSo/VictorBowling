package di.interf;

import data.FrameFactory;
import data.RankingFactory;
import game.interf.Board;
import game.interf.BoardConsole;
import game.interf.BoardDisplay;
import game.interf.ScoreCalculator;
import player.PlayerFactory;
import player.RandomGenerator;

import java.util.Scanner;

public interface CompositionRoot {
    ScoreCalculator provideScoreCalculator();

    Scanner provideScanner();

    BoardConsole provideBoardConsole();

    RankingFactory provideRankingFactory();

    BoardDisplay provideBoardDisplay();

    Board provideBoard();

    RandomGenerator provideRandomGenerator();

    PlayerFactory providePlayerFactory();

    FrameFactory provideFrameFactory();
}
