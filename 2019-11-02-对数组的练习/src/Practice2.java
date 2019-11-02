import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/02
 */
public class Practice2 {
    public int[] sortArrayByParity(int[] A) {
        int[] arr = new int[A.length];
        int t = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                arr[t++] = A[i];
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                arr[t++] = A[i];
            }
        }

        return arr;
    }
}
