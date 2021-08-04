package data;

public class Frames {

    private Frame[] frames;
    private final int noOfFrames;

    public Frames(int noOfFrames, Frame[] frames) {
        this.noOfFrames = noOfFrames;
        this.frames = frames;
    }

    public int getNoOfFrames() {
        return noOfFrames;
    }

    public Frame getFrameAt(int frameIndex) {
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

    public void setFrames(Frame[] frames) {
        this.frames = frames;
    }

    public Frame[] getFrames() {
        return frames;
    }

}
