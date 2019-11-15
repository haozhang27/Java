import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/15
 */
public class Practice2 {
    /**
     * 在字符串1中删除字符串2中的所有字符
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 删除之后的 str1 串
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
