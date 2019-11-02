
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/02
 */
public class Practice1 {
    public char findTheDifference(String s, String t) {
        int ret = 0;
        for (Character c : s.toCharArray()) {
            ret ^= c;
        }

        for (Character c : t.toCharArray()) {
            ret ^= c;
        }

        return (char)ret;
    }
}
