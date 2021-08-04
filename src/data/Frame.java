package data;

public class Frame {

    private final int pins; // the number of pins

    private int pinsFirstRoll;
    private int pinsSecondRoll;
    private int pinsThirdRoll;

    private boolean hasThirdRoll;
    private boolean isLast;

    private int total; //  sum of the points in the rolls
    private int score; // the global total of the points


    public Frame(int pins) {
        this.pins = pins;

        this.pinsFirstRoll = -1;
        this.pinsSecondRoll = -1;
        this.pinsThirdRoll = -1;

        this.hasThirdRoll = false;
        this.isLast = false;

        this.total = -1;
        this.score = -1;
    }

    public int getPinsFirstRoll() {
        return pinsFirstRoll;
    }

    public int getPinsSecondRoll() {
        return pinsSecondRoll;
    }

    public int getPinsThirdRoll() {
        return pinsThirdRoll;
    }

    public int getScore() {
        return score;
    }

    public void setTotal() {
        int sum = pinsFirstRoll + pinsSecondRoll;
        if (hasThirdRoll) {
            sum += pinsThirdRoll;
        }
        this.total = sum;
    }

    public void setPinsFirstRoll(int pinsFirstRoll) {
        this.pinsFirstRoll = pinsFirstRoll;
    }

    public void setPinsSecondRoll(int pinsSecondRoll) {
        this.pinsSecondRoll = pinsSecondRoll;
    }

    public void setPinsThirdShot(int pinsKnockedDown) {
        this.pinsThirdRoll = pinsKnockedDown;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotal() {
        return total;
    }

    public void updateTotal(int points) {
        this.total += points;
    }

    public boolean isStrike() {
        return pinsFirstRoll == pins;
    }

    public boolean isSpare() {
        return pinsFirstRoll != pins && pinsFirstRoll + pinsSecondRoll == pins;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setIsLast(boolean b) {
        isLast = b;
    }

    public void setHasThirdRoll(boolean hasThirdRoll) {
        this.hasThirdRoll = hasThirdRoll;
    }

    @Override
    public String toString() {
        StringBuilder sb =  new StringBuilder();
        if(pinsFirstRoll == -1) {
            sb.append('_');
        } else {
            sb.append(pinsFirstRoll);
        }
        sb.append(' ');
        if(this.isStrike()) {
            sb.append("X");
        } else if(this.isSpare()) {
            sb.append("/");
        } else {
            if(pinsSecondRoll == -1) {
                sb.append('_');
            } else {
                sb.append(pinsSecondRoll);
            }
        }
        sb.append(' ');
        if (hasThirdRoll) {
            sb.append(pinsThirdRoll);
        }
        sb.append(' ');
        if(total == -1) {
            sb.append('_');
        } else {
            sb.append(total);
        }
        sb.append(' ');
        if(total == -1) {
            sb.append('_');
        } else {
            sb.append(score);
        }
        return sb.toString();
    }

    public int getPinsLeftAfterFirstRoll() {
        int pinsLeft = pins;
        if(pinsFirstRoll > 0) {
            pinsLeft = pins - pinsFirstRoll;
        }
        return pinsLeft;
    }
}