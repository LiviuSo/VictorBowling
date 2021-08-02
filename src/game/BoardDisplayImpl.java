package game;

import data.Frames;
import data.Ranking;
import data.RankingComparator;
import game.interf.BoardDisplay;
import player.Player;

import java.util.Arrays;

public class BoardDisplayImpl implements BoardDisplay {

    @Override
    public void showFrames(Frames grid) {
        System.out.printf("%s", grid.toString());
    }

    @Override
    public void showStartMessage() {
        System.out.print("\nLet the game begin !");
    }

    @Override
    public void showEndMessage() {
        System.out.println("\n\nGame over!");
    }

    @Override
    public void showFrameHeader(int frameIndex) {
        System.out.printf("\n\n\n\nFRAME %d ", frameIndex);
        System.out.print("\n-------------------------------------------------------------------------------------");
        System.out.print("-------------------------------------------------------------------------------------");
    }

    @Override
    public void showError(String message) {
        System.out.printf("An error has  occurred: %s", message);
    }

    @Override
    public void showRanking(Player[] players, Frames[] frames) {
        Ranking[] rankings = getRankings(players, frames);
        System.out.print("------------------------------");
        for (int i = 0; i < rankings.length; i++) {
            System.out.printf("\n%d. %-10s : %3d pins", i + 1, rankings[i].getName(), rankings[i].getScore());
        }
    }

    private Ranking[] getRankings(Player[] players, Frames[] frames) {
        int noOfPlayers = players.length;
        Ranking[] rankings = new Ranking[noOfPlayers];
        for (int i = 0; i < noOfPlayers; i++) {
            rankings[i] = new Ranking(players[i].getName(), frames[i].getLast().getScore());
        }
        Arrays.sort(rankings, new RankingComparator());
        return rankings;
    }

    @Override
    public void showPlayerHeader(Player player) {
        System.out.printf("\n\n%s", player.getName());
    }

    @Override
    public void showInviteNumberOfPlayers() {
        System.out.print("\nHow many players [2,3 or 4]? : ");
    }

    @Override
    public void showInviteToRoll(int maxPins) {
        System.out.printf("\nMax to knock down: %d; press enter key to roll!...", maxPins);
    }

    @Override
    public void showNumberOfPinsKnockedDown(int pinsKnockedDown, boolean isHuman) {
        if(!isHuman) {
            System.out.println();
        }
        System.out.printf("Pins knocked down: %d \n", pinsKnockedDown);
    }

    @Override
    public void showInviteToEnterPlayerType() {
        System.out.print("Is auto player? [y/n] ");
    }

    @Override
    public void showInviteToEnterPlayerName(int index) {
        System.out.printf("Enter player %d's name: ", index);
    }

    @Override
    public void showQuestionNewGame() {
        System.out.print("\n\nNew game [y/n]: ");
    }

}
