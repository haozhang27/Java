import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/24
 */
public class Practice4 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }

        int index = m;
        for (int i = 0; i < n; i++) {
            arr[index++] = nums2[i];
        }

        Arrays.sort(arr);
    }
}
