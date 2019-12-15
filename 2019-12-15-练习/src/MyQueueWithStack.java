import java.util.Stack;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/15
 */
public class MyQueueWithStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push (int x) {
        stack1.push(x);
    }

    public int pop () {
        if (stack2.isEmpty()) {
            while (!(stack1.isEmpty())) {
                int v = stack1.pop();
                stack2.push(v);
            }
        }

        return stack1.pop();
    }

    public int peek () {
        if (stack2.isEmpty()) {
            while (!(stack1.isEmpty())) {
                int v = stack1.pop();
                stack2.push(v);
            }
        }

        return stack1.peek();
    }

    public boolean isEmpty () {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public static void main(String[] args) {
    }
}
