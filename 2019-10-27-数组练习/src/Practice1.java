import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/27
 */
public class Practice1 {
    /**
     * 给定一个按非递减顺序排序的整数数组 A，
     * 返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     *
     * @param A 要操作的数组
     * @return 求平方和之后的有序数组
     */
    public int[] sortedSquares(int[] A) {
        int[] arr = A;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);

        return arr;
    }
}
