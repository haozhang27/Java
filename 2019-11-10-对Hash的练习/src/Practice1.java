import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/10
 */
public class Practice1 {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * @param s 字符串
     * @param t 字符串
     * @return true 表示 t为s的字母异位词； false 表示不是
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }


        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != t1[i]) {
                return false;
            }
        }

        return true;
    }
}
