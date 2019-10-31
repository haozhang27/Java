import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/31
 */
public class Practice1 {
    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，
     * 数组中的元素一些出现了两次，另一些只出现一次。
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     *
     * @param nums 要判断的数组
     * @return nums 里面没有的数字
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
