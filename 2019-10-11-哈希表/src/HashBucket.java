import java.util.Random;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/11
 */
public class HashBucket {
    private static class Node {
        private int key;
        private int value;
        private Node next;
    }

    private Node[] array;
    private int size;

    public HashBucket () {
        array = new Node[8];
        size = 0;
    }

    private int hashFunction (int key, int capacity) {
        return key % capacity;
    }

    public int get (int key) {
        int index = hashFunction(key, array.length);
        //在该链表中查找指定的 key
        Node head = array[index];
        Node cur = head;
        while (cur != null) {
            if (key == cur.key) {
                return cur.value;
            }
            cur = cur.next;
        }

        return -1;
    }

    /**
     * key 和 val 形成一个键值对，如果 key 存在，用 val 替换 value
     *                          如果 key 不存在，直接插入
     * @param key 查找的 key
     * @param val 要插入的 val
     * @return 原来的 value
     */
    public int put (int key, int val) {
        int index = hashFunction(key, array.length);
        Node head = array[index];
        Node cur = head;

        while (cur != null) {
            if (key == cur.key) {
                int oldValue = cur.value;
                cur.value = val;
                return oldValue;
            }
            cur = cur.next;
        }

        Node node = new Node();
        node.key = key;
        node.value = val;
        node.next = head;
        //head = node;
        array[index] = node;
        size++;

        if ((double)size / array.length > 0.75) {
            resize();
        }
        return -1;
    }

    /**
     * 插入之后的搬移过程
     * 1.创建一个新链表，大小为原链表的 2 倍
     * 2.遍历原链表 ，
     * 3.找出新的 index，定义一个新节点放到原链表中去
     */
    private void resize () {
       Node[] newArray = new Node[array.length * 2];

       for (int i = 0; i < array.length; i++) {
           Node head = array[i];
           Node cur = head;
           while (cur != null) {
               int index = hashFunction(cur.key, newArray.length);

               Node node = new Node();
               node.key = cur.key;
               node.value = cur.value;

               node.next = newArray[index];
               newArray[index] = node;

               cur = cur.next;
           }
       }
       array = newArray;
    }

    /**
     *  删除 key-value
     *      1.根据 key 得到一个下标 index
     *     2.从数组 array 中取链表的第一个节点
     *     3.在链表中删除 key-value
     * @param key 关键字
     * @return -1 表示不存在 key，其他表示删除成功
     */
    private int remove (int key) {
        int index = hashFunction(key, array.length);

        Node head = array[index];

        Node prev = null;
        Node cur = head;
        while (cur != null) {
            if (key == cur.key) {
                int oldValue = cur.value;
                if (cur == head) {
                    array[index] = head.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return oldValue;
            }

            prev = cur;
            cur = cur.next;
        }
        return -1;
    }


    public static void main(String[] args) {
        HashBucket map = new HashBucket();
        Random random = new Random(20190920);
        for (int i = 0; i < 20; i++) {
            int r = random.nextInt(100);
            map.put(r, r + 1000);
        }
        System.out.println("===");

        map.remove(10);
        map.remove(97);
        map.remove(99);
        System.out.println("==");


    }





}
