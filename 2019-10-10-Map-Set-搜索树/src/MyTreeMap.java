import java.util.Comparator;

/**
 * 这里的 K V 是类型变量，形参
 * @param <K> 节点中 key 的类型
 * @param <V> 节点中 value 的类型
 */
public class MyTreeMap<K, V> {
    /**
     * 这里的 K V 也是形参
     * @param <K> 节点中 key 的类型
     * @param <V> 节点中 value 的类型
     */
    public static class Entry<K, V> {
        //这里的 K V 是类型变量，是 K V 背后类型的运行
        private K key;
        private V value;

        private Entry<K, V> left;
        private Entry<K, V> right;
    }

    private Entry<K, V> root;
    private Comparator<K> comparator = null;

    public MyTreeMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public MyTreeMap () {

    }
    public V get (K key) {
        Entry<K, V> cur = root;
        while (cur != null) {
            // key 和 cur.key 比较
            // 或者 key 的类型是 comparable
            // 或者 需要一个 comparator
            int r;
            if (comparator != null) {
                r = comparator.compare(key, cur.key);
            } else {
                Comparable<K> kComparable = (Comparable<K>) key;
                r = kComparable.compareTo(cur.key);
            }

            if (r == 0) {
                return cur.value;
            } else if (r < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return null;
    }
}
