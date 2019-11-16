import java.util.Stack;

/**
 * 用栈 实现队列
 *
 * @author haozhang
 * @date 2019/11/16
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
