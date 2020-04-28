import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/04/28
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        String str = "";
        System.out.println(reverseSentence(str));
    }

    /**
     * “I am a student.” 转成  “student. a am I”
     * @param str
     * @return
     */
    public static String reverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        String[] s = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(s[i]);
            } else {
                sb.append(s[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 输出字符串循环左移n位的结果
     * @param str
     * @param n
     * @return
     */
    public static String leftRotateString(String str,int n) {
        if (str.length() < n || str == null) {
            return "";
        }
        return str.substring(n) + str.substring(0, n);
    }

    /**
     * 和为sum的连续序列
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int front = 1;
        int last = 2;
        while (front < last) {
            //等差数列求和
            int curSum = (last - front + 1) * (front + last) / 2;

            //相等
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = front; i < last + 1; i++) {
                    list.add(i);
                }
                ret.add(list);
                front++;

                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else if (curSum < sum) {
                last++;

                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
            } else {
                front++;
            }
        }
        return ret;
    }
}
