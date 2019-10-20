/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/20
 */
public class Practice3 {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if (arr[i] != arr[j]) {
                return isPalindrome(arr, i, j - 1) || isPalindrome(arr, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] s, int l, int r) {
        for (int i = l, j = r; i < j; i++, j--) {
            if (s[i] != s[j]) {
                return false;
            }
        }
        return true;
    }
}
