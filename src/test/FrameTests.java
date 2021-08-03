package test;

import data.Frame;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FrameTests {

    @Test
    public void testFramePinsSetters() {
        Frame frame = new Frame(10);
        frame.setPinsFirstRoll(2);
        frame.setPinsSecondRoll(4);
        Assert.assertEquals(frame.getPinsFirstRoll() + frame.getPinsSecondRoll(), 6);
    }

    @Test
    public void testFramePinsSettersLast() {
        Frame frame = new Frame(10);
        frame.setPinsFirstRoll(2);
        frame.setPinsSecondRoll(4);
        frame.setPinsThirdShot(9);
        Assert.assertEquals(frame.getPinsFirstRoll() + frame.getPinsSecondRoll() + frame.getPinsThirdRoll(), 15);
    }

    @Test
    public void testIsStrike() {
        Frame frame = new Frame(10);
        frame.setPinsFirstRoll(10);
        frame.setPinsSecondRoll(0);
        Assert.assertTrue(frame.isStrike());
    }

    @Test
    public void testIsSpare() {
        Frame frame = new Frame(10);
        frame.setPinsFirstRoll(7);
        frame.setPinsSecondRoll(3);
        Assert.assertTrue(frame.isSpare());
    }

    @Test
    public void testTotalStrike() {
        Frame frame  = new Frame(10);
        frame.setPinsFirstRoll(10);
        frame.setPinsSecondRoll(0);
        frame.setTotal();
        Assert.assertEquals(frame.getTotal(), 10);
    }

    @Test
    public void testTotalSpare() {
        Frame frame  = new Frame(10);
        frame.setPinsFirstRoll(4);
        frame.setPinsSecondRoll(6);
        frame.setTotal();
        Assert.assertEquals(frame.getTotal(), 10);
    }

    @Test
    public void testTotalLast() {
        Frame frame  = new Frame(10);
        frame.setHasThirdRoll(true);
        frame.setPinsFirstRoll(10);
        frame.setPinsSecondRoll(0);
        frame.setPinsThirdShot(1);
        frame.setTotal();
        Assert.assertEquals(frame.getTotal(), 11);
    }

    @Test
    public void testTotalLast2() {
        Frame frame  = new Frame(10);
        frame.setHasThirdRoll(true);
        frame.setPinsFirstRoll(4);
        frame.setPinsSecondRoll(5);
        frame.setPinsThirdShot(6);
        frame.setTotal();
        Assert.assertEquals(frame.getTotal(), 15);
    }

    @Test
    public void testTotalLast3() {
        Frame frame  = new Frame(10);
        frame.setHasThirdRoll(true);
        frame.setPinsFirstRoll(7);
        frame.setPinsSecondRoll(1);
        frame.setPinsThirdShot(4);
        frame.setTotal();
        Assert.assertEquals(frame.getTotal(), 12);
    }

    @Test
    public void testUpdateTotal() {
        Frame frame  = new Frame(10);
        frame.setPinsFirstRoll(4);
        frame.setPinsSecondRoll(6);
        frame.setTotal();
        frame.updateTotal(5);
        Assert.assertEquals(frame.getTotal(), 15);
    }

    @Test
    public void testPinsLeft() {
        Frame  frame = new Frame(10);
        frame.setPinsFirstRoll(4);
        Assert.assertEquals(frame.getPinsLeftAfterFirstRoll(), 6);
    }

    @Test
    public void testPinsLeftStrike() {
        Frame  frame = new Frame(10);
        frame.setPinsFirstRoll(10);
        Assert.assertEquals(frame.getPinsLeftAfterFirstRoll(), 0);
    }


}
