package game.interf;

import data.Frames;
import data.Roll;

public interface ScoreCalculator {

    boolean updateRolls(Frames frames, int frameIndex, int pinsKnockedDown, Roll roll);

    void updateTotals(Frames frames, int index);

    void updateScores(Frames frames, int index);

}
