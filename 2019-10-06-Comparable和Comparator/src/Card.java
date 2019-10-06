import java.util.Comparator;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/06
 */
public class Card implements Comparable<Card> {
    int rank;
    int suit;


    @Override
    public int compareTo(Card o) {
        return rank - o.rank;
    }
}

class DouDiZhuCnmparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.suit - o2.suit;
    }
}
