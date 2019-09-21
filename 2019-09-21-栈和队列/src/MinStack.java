import java.util.Stack;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/21
 */
class MinStack {
    private Stack<Integer> normal = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        normal.push(x);

        if (min.isEmpty()) {
            min.push(x);
        } else {
            int m = min.peek();
            if (x <= m) {
                min.push(x);
            }
        }
    }

    public void pop() {
        if (normal.isEmpty()) {
            return;
        } else {
            normal.pop();
        }

        if (min.isEmpty()) {
            return;
        } else {
            min.pop();
        }
    }

    public int top() {
        if (!normal.isEmpty()) {
            return normal.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!min.isEmpty()) {
            return min.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
