public class Frames {

    private final Frame[] frames;
    private final int noOfFrames;

    public Frames(int noOfFrames, int noOfPins) {
        this.noOfFrames = noOfFrames;
        frames = new Frame[noOfFrames];
        for (int i =  0;  i < noOfFrames;  i++) {
            frames[i] = new Frame(noOfPins);
        }
        frames[noOfFrames-1].setIsLast(true);
    }

    public int getNoOfFrames() {
        return noOfFrames;
    }

    Frame getFrameAt(int frameIndex) {
        return frames[frameIndex];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < frames.length; ++i) {
            sb.append("F").append(i+1).append(": ");
            sb.append(frames[i]);
            sb.append(" | ");
        }
        return sb.toString();
    }

    public Frame getLast() {
        return frames[noOfFrames-1];
    }
}
