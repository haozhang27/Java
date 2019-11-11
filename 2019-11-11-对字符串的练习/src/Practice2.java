import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/11
 */
public class Practice2 {
    /**
     * 给定字符串 str1 和 str2，删除 str1 中的所有 str2 字符
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 删除之后的字符串
     */
    public String deleteChar(String str1, String str2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (!set.contains(c) || c == ' ') {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
