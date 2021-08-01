import java.util.Arrays;

public class Board {
    private final ScoreCalculator scoreCalculator;

    public Board(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

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
        showFrames(frames);

        return continueToRoll;
    }

    private void showFrames(Frames grid) {
        System.out.printf("%s", grid.toString());
    }

    public void showStartMessage() {
        System.out.println("Let the game begin !\n");
    }

    public void showEndMessage() {
        System.out.println("\n\nGame over!");
    }

    public void showFrameHeader(int frameIndex) {
        System.out.printf("\n\nFRAME %d: ", frameIndex);
    }

    public void showError(String message) {
        System.out.printf("An error has  occurred: %s", message);
    }

    public void showRanking(Player[] players, Frames[] frames) {
        Ranking[] rankings = getRankings(players, frames);
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

    public void showPlayerHeader(Player player) {
        System.out.printf("\n\n%s", player.getName());

    }

    public void invitePlayer(int index) {
        System.out.printf("Enter player %d's name: ", index);
    }

    public void showInviteNumberOfPlayers() {
        System.out.println("\nHow many players [2,3 or 4]? : ");
    }

    public void showInviteToRoll(int maxPins) {
        System.out.printf("\n Max to knock down: %d; press a key to roll!... ", maxPins);
    }

}
