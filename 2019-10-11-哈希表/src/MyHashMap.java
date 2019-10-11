/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/11
 */
public class MyHashMap<K, V> {
    /**
     * 只有跟在 class 类名称之后的 才叫做 类型变量形参；
     * 其他地方都是在使用
     */
    private static class Node<M, N> {
        private M key;
        private N value;
        private Node<M, N> next;
    }

    private Node<K, V>[] array;
    private int size;

    public MyHashMap() {
        //数组长度一定是 2^n
        array = (Node<K, V>[])new Object[16];
        size = 0;
    }

    /**
     * 演示会调用 K 类型的 hashCode 和 equals 方法
     * 所以必须正确覆写 hashCode 和 equals 方法
     * 如果 equals 为 true，则 hashCode 必须相等
     * @param key 关键字
     * @return
     */
    public V get(K key) {
        //1.把 关键字 转成 int 类型
        int hash = key.hashCode();

        //2.把 hash 转成一个合法的下标
        //int index = hash % array.length
        int n = array.length;

        //使得 hash 更均匀
        hash = ((hash >> 16) ^ hash);
        int index = hash ^ (n - 1);

        Node<K, V> head = array[index];
        Node<K, V> cur = head;
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur.value;
            }

            cur = cur.next;
        }
        return null;
    }
}
