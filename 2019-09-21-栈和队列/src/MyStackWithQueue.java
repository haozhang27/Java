import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * @author haozhang
 * @date 2019/09/21
 */
public class MyStackWithQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private int sizeOf = 0;

    public void push (int element) {
        queue.add(element);
        sizeOf++;
    }

    public int pop () {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            queue.add(v);
        }

        sizeOf--;
        return queue.remove();
    }

    public int peek () {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            queue.add(v);
        }

        int v = queue.remove();
        queue.add(v);
        return v;
    }

    public int search (int value) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            if (queue.element() == value) {
                return i;
            }
        }

        return -1;
    }

    public boolean isEmpty () {
        return queue.isEmpty();
    }

    public int size () {
        return sizeOf;
    }

    public static void main (String[] args) {
        MyStackWithQueue myStackWithQueue = new MyStackWithQueue();
        myStackWithQueue.push(1);
        myStackWithQueue.push(2);
        myStackWithQueue.push(3);
        System.out.println(myStackWithQueue.size());

        System.out.println(myStackWithQueue.peek());
        System.out.println(myStackWithQueue.search(2));

        System.out.println(myStackWithQueue.pop());
        System.out.println(myStackWithQueue.pop());
        System.out.println(myStackWithQueue.pop());

        System.out.println(myStackWithQueue.size());

        System.out.println(myStackWithQueue.isEmpty());
    }
}


