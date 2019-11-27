import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/27
 */
public class Practice1 {
    /**
     * 检查是否为子串
     * @param p 给定的字符数组
     * @param n 字符数组大小
     * @param s 母串
     * @return 数组中 true表示为子串；false 表示不是
     */
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] ret = new boolean[n];

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            String str = p[i];
            for (int j = 0; j < str.length(); j++) {
                if (set.contains(str.charAt(j))){
                    ret[i] = true;
                } else {
                    ret[i] = false;
                }
            }
        }

        return ret;
    }
}
