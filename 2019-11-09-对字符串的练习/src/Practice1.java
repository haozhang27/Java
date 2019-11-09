import java.util.LinkedList;
import java.util.Queue;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/09
 */
public class Practice1 {
    /**
     * 判断括号是否有效
     * @param A 给定的字符串
     * @param n 字符串长度
     * @return true 表示括号有效（括号都是左括号和右括号一一对应，A中没有其他字符）；false 表示无效
     */
    public boolean chkParenthesis(String A, int n) {
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < A.length(); i++) {

            if (A.charAt(i) == '(') {
                queue.add(A.charAt(i));
                count++;
            }

            if (A.charAt(i) == ')') {
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
