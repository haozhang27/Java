/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/12
 */
public class Practice1 {
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
