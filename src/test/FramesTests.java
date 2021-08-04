package test;

import data.Frame;
import data.FrameFactory;
import data.Frames;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FramesTests {
    FrameFactory frameFactory = new FrameFactory();
    Frames frames = frameFactory.getFrames(2, 10);

    @Test
    public void testGetFrameAt() {
        Frame frame0 = new Frame(10);
        Frame frame1 = new Frame(10);

        frame0.setPinsFirstRoll(8);
        frame0.setPinsSecondRoll(1);

        frame1.setPinsFirstRoll(4);
        frame1.setPinsFirstRoll(6);

        Frame[] frameArray = new Frame[2];
        frameArray[0] = frame0;
        frameArray[1] = frame1;
        frames.setFrames(frameArray);

        Assert.assertEquals(frames.getFrameAt(0), frame0);
        Assert.assertEquals(frames.getFrameAt(1), frame1);
        Assert.assertEquals(frames.getFrameAt(0).getPinsFirstRoll(), frame0.getPinsFirstRoll());
        Assert.assertEquals(frames.getFrameAt(0).getPinsSecondRoll(), frame0.getPinsSecondRoll());
        Assert.assertEquals(frames.getFrameAt(1).getPinsFirstRoll(), frame1.getPinsFirstRoll());
        Assert.assertEquals(frames.getFrameAt(1).getPinsSecondRoll(), frame1.getPinsSecondRoll());
    }

    @Test
    public void testGetLast() {
        Frame frame0 = new Frame(10);
        Frame frame1 = new Frame(10);

        frame0.setPinsFirstRoll(8);
        frame0.setPinsSecondRoll(1);

        frame1.setPinsFirstRoll(4);
        frame1.setPinsFirstRoll(6);

        Frame[] frameArray = new Frame[2];
        frameArray[0] = frame0;
        frameArray[1] = frame1;
        frames.setFrames(frameArray);

        Assert.assertEquals(frames.getLast(), frame1);
        Assert.assertEquals(frames.getLast().getPinsFirstRoll(), frame1.getPinsFirstRoll());
        Assert.assertEquals(frames.getLast().getPinsSecondRoll(), frame1.getPinsSecondRoll());
    }

}
