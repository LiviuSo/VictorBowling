import java.util.Comparator;

class RankingComparator implements Comparator<Ranking> {
    @Override
    public int compare(Ranking o1, Ranking o2) {
        return o2.getScore() - o1.getScore(); // reverse order
    }
}