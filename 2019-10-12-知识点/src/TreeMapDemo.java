import javax.swing.tree.TreeNode;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.value - o2.value;
    }
}

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/12
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        Card p = new Card(1, "♥");
        Card q = new Card(1, "♥");

        CardComparator comptor = new CardComparator();
        TreeSet<Card> set = new TreeSet<>(comptor);
        set.add(p);

        System.out.println(set.contains(q));
        TreeMap<Card, String> map = new TreeMap<>(comptor);
        map.put(p, "♥A");
        System.out.println(map.get(q));


        MaJiang m1 = new MaJiang("万", "一");
        MaJiang m2 = new MaJiang("万", "一");
        TreeMap<MaJiang, String> map2 = new TreeMap<>();
        map2.put(m1, "胡牌");

        System.out.println(map2.get(m2));

    }
}
