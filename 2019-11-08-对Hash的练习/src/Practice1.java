import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/08
 */
public class Practice1 {
    /**
     * 给定一个字符串，找出其中不含有重复字符的 最长子串 的长度。
     * @param s 给定的字符串
     * @return 最长子串的长度
     */
    public int lengthOfLongestSubString(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int ret = 0;
        int len = s.length();
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ret = Math.max(ret, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return ret;
    }
}
