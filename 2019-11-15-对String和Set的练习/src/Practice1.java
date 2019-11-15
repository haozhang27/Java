/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/15
 */
public class Practice1 {
    /**
     * 给定两个字符串，把字符串2放到字符串1中能构成回文串的个数
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 可构成回文串的总数
     */
    public int countOfPalindrome(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i, str2);
            if (isPalindrome(sb.toString())) {
                count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(String s) {
        int front = 0;
        int last = s.length() - 1;
        while (front < last) {
            if (s.charAt(front) != s.charAt(last)) {
                return false;
            }

            front++;
            last--;
        }
        return true;
    }
}
