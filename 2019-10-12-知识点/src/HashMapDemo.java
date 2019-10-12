import java.util.HashMap;
import java.util.HashSet;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/12
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Card p = new Card(1, "♥");
        Card q = new Card(1, "♥");
        System.out.println(p.hashCode());
        System.out.println(q.hashCode());

        HashSet<Card> set = new HashSet<>();
        set.add(p);
        System.out.println(set.contains(q));

        HashMap<Card, String> map = new HashMap<>(16);
        map.put(p, "红桃A");
        System.out.println(map.get(q));
    }
}
