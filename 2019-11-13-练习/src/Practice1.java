import java.util.*;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/13
 */
public class Practice1 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.peek());
            }
        }

        return stack2.pop();
    }
}
