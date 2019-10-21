/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/21
 */
public class Practice4 {
    /**
     * 输入: "aaa"
     * 输出: 6
     * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
     *
     * @param s 要求回文子串的字符串
     * @return 所有回文串的个数
     */
    public int countSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += countSegment(s, i, i);
            res += countSegment(s, i, i + 1);
        }
        
        return res;
    }

    private int countSegment(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
        return count;
    }


}
