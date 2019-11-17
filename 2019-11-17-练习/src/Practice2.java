import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/17
 */
public class Practice2 {
    /**
     * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
     * @param s 给定的字符串
     * @param n 字符串长度
     * @return true 表示是合法括号串；false 表示不是
     */
    public boolean checkParenthesis(String s, int n) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                count++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    count++;
                }
            }
        }

        if (stack.isEmpty() && n == count) {
            return true;
        }

        return false;
    }

    public boolean checkParenthesis2(String s, int n) {
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                queue.add(s.charAt(i));
                count++;
            }

            if (s.charAt(i) == ')') {
                queue.poll();
                count++;
            }
        }

        if (count == n && queue.isEmpty()) {
            return true;
        }

        return false;

    }
}
