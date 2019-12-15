import java.util.ArrayList;

/**
 * 应用 栈 的知识来判断 括号 是否都匹配
 *
 * @author haozhang
 * @date 2019/12/15
 */
public class Solution {
    public boolean isValid (String s) {
        ArrayList<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.add(ch);
            }

            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char left = stack.remove(stack.size() - 1);
                if (!match(left, ch)) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean match (char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }

        if (left == '[' && right == ']') {
            return true;
        }

        if (left == '{' && right == '}') {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}"));
    }
}
