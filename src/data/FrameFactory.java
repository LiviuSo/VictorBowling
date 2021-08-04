package data;

public class FrameFactory {

    public Frame getFrame(int noOfPins) {
        return new Frame(noOfPins);
    }

    public Frame getLastFrame(int noOfPins) {
        Frame frame = new Frame(noOfPins);
        frame.setIsLast(true);
        return frame;
    }

    public Frames getFrames(int noOfFrames, int noOfPins) {

        Frame[] frameArray = new Frame[noOfFrames];
        for (int i = 0; i < noOfFrames; i++) {
            frameArray[i] = getFrame(noOfPins);
        }
        frameArray[noOfFrames - 1] = getLastFrame(noOfPins);

        return new Frames(noOfFrames, frameArray);
    }

}
