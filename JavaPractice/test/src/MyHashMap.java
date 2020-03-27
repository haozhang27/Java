/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/27
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    private static class MyEntry<K, V> {
        K key;
        V value;
        MyEntry<K, V> next;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private MyEntry<K, V>[] table = new MyEntry[16];
    private int size;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;



    @Override
    public V get(K key) {
        int hash = key.hashCode();
        hash = (hash >>> 16) ^ hash;
        int index = hash & (table.length - 1);

        MyEntry<K, V> head = table[index];
        MyEntry<K, V> cur = head;
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode();
        hash = (hash >>> 16) ^ hash;
        int index = hash & (table.length - 1);

        MyEntry<K, V> head = table[index];
        MyEntry<K, V> cur = head;
        while (cur != null) {
            if (key.equals(cur.key)) {
                V oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
            cur = cur.next;
        }


        //没找到
        MyEntry<K, V> newNode = new MyEntry<>(key, value);

        //尾插
        if (head == null) {
            table[index] = newNode;
        } else {
            MyEntry<K, V> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }

        size++;

        if ((double)size / table.length >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        return null;
    }

    private void resize() {
        MyEntry<K, V>[] newTable = new MyEntry[2*table.length];

        //先遍历到链表，再从链表找
        for (int i = 0; i < table.length; i++) {
            MyEntry<K, V> node = table[i];
            while (node != null) {
                MyEntry<K, V> newNode = new MyEntry<>(node.key, node.value);
                int hash = newNode.key.hashCode();
                hash = (hash >>> 16) ^ hash;
                int index = hash & (table.length - 1);

                //头插
                newNode.next = newTable[index];
                newTable[index] = newNode;
            }
        }

        table = newTable;
    }
}
