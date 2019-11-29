/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/29
 */
public class Practice2 {
    /**
     * 给定一个字符串   输出其对应的破译字符串
     * @param s 给定的字符串
     * @return 破译的字符串
     */
    public String characterOfInput(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                c = (char)(s.charAt(i) - 5);
                if (c < 'A') {
                    c = (char)(c + 26);
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
