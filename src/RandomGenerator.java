import java.util.Random;

public class RandomGenerator {

    /**
     *
     * @param max The max number to be returned
     * @return Random number between 0 and max
     */
    int getRandomInt(int max) {
        Random random = new Random(System.currentTimeMillis());
        return Math.abs(random.nextInt()) % max + 1;
    }

}
