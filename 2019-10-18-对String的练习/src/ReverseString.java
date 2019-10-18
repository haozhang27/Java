/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/18
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            System.out.println(s);
        }

        if (s.length % 2 == 1) {
            for (int i = 0; i < (s.length / 2) + 1; i++) {
                swap(s, i, s.length - 1 - i);
            }
            System.out.println(s);
        }

        if (s.length % 2 == 0) {
            for (int i = 0; i < s.length / 2; i++) {
                swap(s, i, s.length - 1 - i);
            }
            System.out.println(s);
        }
    }

    private void swap(char[] array, int i, int j) {
        char t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
