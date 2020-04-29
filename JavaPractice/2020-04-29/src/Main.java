
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/04/29
 */
public class Main {
    static Map<Character, Integer> Map = new LinkedHashMap<>(16);
    public static void insert(char ch) {
        int n = Map.getOrDefault(ch, 0);
        Map.put(ch, n + 1);
    }

    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时
     * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     *
     * 如果当前字符流没有存在出现一次的字符，返回#字符。
     * @return
     */
    public static char firstAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : Map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val == 1) {
                return key;
            }
        }
        return '#';
    }

    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、e
     * lse、switch、case等关键字及条件判断语句（A?B:C）。
     * @param n
     * @return
     */
    public int sumSolution(int n) {
        int sum = (int)(Math.pow(n, 2) + n);
        return sum >> 1;
    }

    /**
     * 0 ~ n-1  每次过m个后 删除第 m 个  从删除后的一个开始 继续过 m-1
     * 最后能否只剩一个
     * @param n
     * @param m
     * @return
     */
    public static int lastRemainingSolution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }


        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }


        if (list.size() == 1) {
            return list.get(0);
        } else {
            return -1;
        }
    }
}
