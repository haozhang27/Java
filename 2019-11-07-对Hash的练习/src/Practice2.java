import java.util.*;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/07
 */
public class Practice2 {
    /**
     * 计算两个数组的交集
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集的数组
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int length = Math.min(nums1.length, nums2.length);
        int[] arr = new int[length];
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        int count = 0;
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            if (set.contains(nums2[i])) {
                arr[count] = num;
                count++;
                set.remove(num);
            }
        }

        return Arrays.copyOfRange(arr, 0, count);
    }
}
