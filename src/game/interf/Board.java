package game.interf;

import data.Frames;
import data.Roll;
import player.Player;

public interface Board {
    boolean updateFrameGrid(Frames frames, int frameIndex, int pinsKnockedDown, Roll roll);

    void showInviteToEnterPlayerType();

    void showInviteToEnterPlayerName(int i);

    void showQuestionNewGame();

    void showRanking(Player[] players, Frames[] frames);

    void showInviteNumberOfPlayers();

    void showError(String s);

    void showStartMessage();

    void showEndMessage();

    void showFrameHeader(int i);

    void showPlayerHeader(Player player);

    void showInviteToRoll(int maxPins);

    void showNumberOfPinsKnockedDown(int pinsKnockedDown, boolean isHuman);

    String enterPlayerType();

    String enterPlayerName();

    int enterNumberOfPlayers();

    String enterConfirmationNewGame();
}
