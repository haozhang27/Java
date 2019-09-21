import java.util.Arrays;

/**
 * 使用数组来实现 栈
 *
 * @author haozhang
 * @date 2019/09/21
 */
public class MyStack {
    private int[] array = new int[10];
    private int top = 0;
    private void ensureCapacity() {
        if (top < array.length) {
            return;
        }

        array = Arrays.copyOf(array, 2 * array.length);
    }

    public int push (int element) {
        ensureCapacity();
        array[top] = element;
        top++;
        return element;
    }

    public int pop () {
        return array[top--];
    }

    public boolean isEmpty () {
        return top == 0;
    }

    public int size () {
        return top;
    }

    public int search(int element) {
        for (int i = 0; i < top; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.size());

        System.out.println(myStack.search(2));

        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.size());
    }
}
