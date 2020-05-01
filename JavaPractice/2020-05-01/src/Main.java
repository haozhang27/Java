
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/05/01
 */
public class Main {

    /**
     * 压缩字符串  压缩后比原长度小输出压缩的，比原长度长输出原字符串
     * "aabcccccaaa"
     * 返回："a2b1c5a3"
     *
     * "welcometonowcoderrrrr"
     * 返回："welcometonowcoderrrrr"
     * @param s
     * @return
     */
    public static String zipString(String s) {
        // write code here
        if (s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int begin = 1;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            sb.append(c);

            int index = getEndIndex(s, c, begin);
            System.out.println(index);
            int count = index - i;
            System.out.println(count);
            sb.append(count);
            begin = index;
            i = index;
        }

        if (sb.length() < s.length()) {
            return sb.toString();
        } else {
            return s;
        }
    }

    /**
     * 获取该字符最后出现的位置的下一个
     * @param s
     * @param c
     * @param begin
     * @return
     */
    public static int getEndIndex(String s, char c, int begin) {
        for (int i = begin; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                return i;
            }
        }
        return s.length();
    }

    static List<Integer> list = new ArrayList<>();
    public static void insert(Integer num) {
        list.add(num);
    }

    /**
     * 获取数据流中的中位数
     * @return
     */
    public static Double getMedian() {
        Collections.sort(list);
        System.out.println(list);
        if (list.size() == 0){
            return 0.00;
        }


        if (list.size() == 2) {
            double ret = ((double)list.get(0) + (double)list.get(1)) / 2;
            return ret;
        }

        if (list.size() % 2 == 1) {
            int index = list.size() / 2;
            double ret = (double)list.get(index);
            return ret;
        }

        int index = list.size() / 2;
        double ret = ((double)list.get(index) + (double)list.get(index - 1)) / 2;
        return ret;
    }
}
