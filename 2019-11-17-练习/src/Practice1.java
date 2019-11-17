/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/17
 */
public class Practice1 {
    /**
     * 输出一个字符串中连续最长的数字串
     * @param s 给定的字符串
     * @return 最长数字串
     */
    public String continuousOfLongest(String s) {
        int max = 0;
        int count = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count++;
                if (max < count) {
                    max = count;
                    last = i;
                }
            } else {
                count = 0;
            }

        }
        return s.substring(last - max + 1, last + 1);
    }
}
