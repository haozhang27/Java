/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/20
 */
public class Practice2 {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if ('0' <= arr[i] && arr[i] <= '9') {
                arr[count] = arr[i];
                count++;
            } else if ('a' <= arr[i] && arr[i] <= 'z') {
                arr[count] = arr[i];
                count++;
            } else if ('A' <= arr[i] && arr[i] <= 'Z') {
                arr[count] = (char) (arr[i] - 'A' + 'a');
                count++;
            }
        }

        int j = 0;
        count--;
        while (j < count) {
            if (arr[j] != arr[count]) {
                return false;
            }
            j++;
            count--;
        }
        return true;
    }
}
