
import java.util.Comparator;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/11
 */
public class MyTreeMap <K, V> {
    public static class Entry<M, N> {
        private M key;
        private N value;

        private Entry<M, N> left;
        private Entry<M, N> right;
    }

    private Entry<K, V> root;
    private Comparator<K> comparator = null;

    public MyTreeMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public V get (K key) {
        Entry<K, V> cur = root;
        while (cur != null) {
            int ret;
            if (comparator != null) {
                ret = comparator.compare(key, cur.key);
            } else {
                Comparable<K> KComparable = (Comparable<K>)key;
                ret = KComparable.compareTo(cur.key);
            }

            if (ret == 0) {
                return cur.value;
            } else if (ret < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }
}
