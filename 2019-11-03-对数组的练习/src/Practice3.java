/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/03
 */
public class Practice3 {
    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     *
     * @param A 给定的数组
     * @return 排序后的数组
     */
    public int[] sortArrayByParity(int[] A) {
        int[] arr = new int[A.length];
        int t = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2  == 0) {
                arr[t] = A[i];
                t += 2;
            }
        }

        t = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                arr[t] = A[i];
                t += 2;
            }
        }
        return arr;
    }
}
