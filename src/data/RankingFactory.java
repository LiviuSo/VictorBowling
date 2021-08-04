package data;

public class RankingFactory {

    public Ranking getRanking(String name, int score) {
        return new Ranking(name, score);
    }

}
