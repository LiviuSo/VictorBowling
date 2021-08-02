package game.interf;

import data.Frames;
import player.Player;

public interface BoardDisplay {
    void showFrames(Frames grid);

    void showStartMessage();

    void showEndMessage();

    void showFrameHeader(int frameIndex);

    void showError(String message);

    void showRanking(Player[] players, Frames[] frames);

    void showPlayerHeader(Player player);

    void showInviteNumberOfPlayers();

    void showInviteToRoll(int maxPins);

    void showNumberOfPinsKnockedDown(int pinsKnockedDown, boolean isHuman);

    void showInviteToEnterPlayerType();

    void showInviteToEnterPlayerName(int index);

    void showQuestionNewGame();
}
