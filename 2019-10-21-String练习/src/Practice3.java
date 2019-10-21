/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/21
 */
public class Practice3 {
    /**
     * 输入: "aaa"
     * 输出: 6
     * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
     * @param s 要求回文子串的字符串
     * @return 所有回文子串个数
     */
    public int countSubstring(String s) {
        int count = 0;
        int left;
        int right;
        for (left = 0; left < s.length(); left++) {
            for (right = left; right < s.length(); right++) {
                if (isPalindrome(s, left, right)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
