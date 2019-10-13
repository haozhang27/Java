import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/13
 */
public class PrevPerm {
    public static int[] prevPermOpt1(int[] A) {
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                int max = i + 1;
                for (int j = i + 2; j < A.length; j++) {
                    if (A[j] < A[i] && A[j] > A[max]) {
                        max = j;
                    }
                }
                int t = A[i];
                A[i] = A[max];
                A[max] = t;
                return A;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = { 3, 1, 1, 3 };
        System.out.println(Arrays.toString(prevPermOpt1(A)));
    }
}
