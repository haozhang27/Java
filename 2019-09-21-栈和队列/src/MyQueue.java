
/**
 * 使用链表实现 队列
 *
 * @author haozhang
 * @date 2019/09/21
 */
public class MyQueue {
    static class ListNode {
        private int value;
        private ListNode next;

        ListNode (int val) {
            this.value = val;
            this.next = null;
        }
    }

    private ListNode front = null;
    private ListNode rear = null;
    private int size = 0;

    public void push (int element) {
        size++;
        if (rear != null) {
            rear.next = new ListNode(element);
            rear = rear.next;
        } else {
            front = rear = new ListNode(element);
        }
    }

    public int pop () {
        int element = front.value;
        size--;
        front = front.next;
        if (front == null) {
            rear = null;
        }

        return element;
    }

    public int rear () {
        return rear.value;
    }

    public int front () {
        return front.value;
    }

    public int size () {
        return size;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.size());

        System.out.println(myQueue.front());
        System.out.println(myQueue.rear());

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

        System.out.println(myQueue.size());
    }
}
