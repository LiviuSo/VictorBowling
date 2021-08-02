package game;

import data.Frame;
import data.Frames;
import data.Roll;
import exception.ExceptionTool;
import game.interf.ScoreCalculator;

public class ScoreCalculatorImpl implements ScoreCalculator {

    protected int noOfPins;

    public ScoreCalculatorImpl(int noOfPins) {
        this.noOfPins = noOfPins;
    }

    /**
     * @param frames The array of all frames
     * @param index  The index of the current frame
     */
    @Override
    public void updateTotals(Frames frames, int index) {
        ExceptionTool.checkIndex(index, frames.getNoOfFrames());

        Frame crtFrame = frames.getFrameAt(index);
        crtFrame.setTotal();
        if (index > 1) { //  2+ frames
            Frame prevPrevFrame = frames.getFrameAt(index - 2);
            Frame prevFrame = frames.getFrameAt(index - 1);

            // update the total of the  preview
            if (prevFrame.isSpare()) {
                prevFrame.updateTotal(crtFrame.getPinsFirstRoll());
            } else if (prevFrame.isStrike()) {
                if (!crtFrame.isStrike() || (crtFrame.isStrike() && crtFrame.isLast())) {
                    prevFrame.updateTotal(crtFrame.getPinsFirstRoll() + crtFrame.getPinsSecondRoll());
                }
            }
            // update  the total prev of prev if a series of strikes
            if (prevPrevFrame.isStrike() && prevFrame.isStrike()) {
                prevPrevFrame.updateTotal(prevFrame.getPinsFirstRoll() + crtFrame.getPinsFirstRoll());
            }
        } else if (index == 1) { // the first 2 frames have been played
            Frame firstFrame = frames.getFrameAt(0);
            if (firstFrame.isSpare()) {
                firstFrame.updateTotal(crtFrame.getPinsFirstRoll());
            } else if (firstFrame.isStrike()) {
                if (!crtFrame.isStrike()) {
                    firstFrame.updateTotal(crtFrame.getPinsFirstRoll() + crtFrame.getPinsSecondRoll());
                }
            }
        }
    }

    @Override
    public void updateScores(Frames frames, int index) {
        ExceptionTool.checkIndex(index, frames.getNoOfFrames());

        Frame crtFrame = frames.getFrameAt(index);
        // update only the scores of the last 3 frames; the others before won't change
        if (index > 2) {
            Frame frameAtIndexMinus3 = frames.getFrameAt(index - 3);
            Frame frameAtIndexMinus2 = frames.getFrameAt(index - 2);
            Frame frameAtIndexMinus1 = frames.getFrameAt(index - 1);
            frameAtIndexMinus2.setScore(frameAtIndexMinus3.getScore() + frameAtIndexMinus2.getTotal());
            frameAtIndexMinus1.setScore(frameAtIndexMinus2.getScore() + frameAtIndexMinus1.getTotal());
            crtFrame.setScore(frameAtIndexMinus1.getScore() + crtFrame.getTotal());
        } else if(index == 2) {
            Frame firstFrame = frames.getFrameAt(0);
            Frame secondFrame = frames.getFrameAt(1);
            firstFrame.setScore(firstFrame.getTotal());
            secondFrame.setScore(firstFrame.getScore() + secondFrame.getTotal());
        } else if(index == 1) {
            Frame firstFrame = frames.getFrameAt(0);
            crtFrame.setScore(firstFrame.getScore() + crtFrame.getTotal());
        } else { // index == 0
            crtFrame.setScore(crtFrame.getTotal());
        }
    }

    @Override
    public boolean updateRolls(Frames frames, int frameIndex, int pinsKnockedDown, Roll roll) {
        ExceptionTool.checkIndex(frameIndex, frames.getNoOfFrames());

        int noOfFrames = frames.getNoOfFrames();
        if (frameIndex < 0 || frameIndex >= noOfFrames) throw new ArrayIndexOutOfBoundsException();

        boolean continueToRoll = true;
        Frame frame = frames.getFrameAt(frameIndex);
        switch (roll) {
            case FIRST:
                frame.setPinsFirstRoll(pinsKnockedDown);
                if (!frame.isLast() && frame.isStrike()) {
                    frame.setPinsSecondRoll(0);
                    continueToRoll = false;
                }
                break;
            case SECOND:
                frame.setPinsSecondRoll(pinsKnockedDown);
                continueToRoll = false;
                if (frame.isLast() && (frame.isStrike() || frame.isSpare())) {
                    frame.setHasThirdRoll(true);
                    continueToRoll = true;
                }
                break;
            case THIRD:
                frame.setPinsThirdShot(pinsKnockedDown);
                continueToRoll = false; // the frame is definitely over
                break;
        }
        return continueToRoll;
    }

}
