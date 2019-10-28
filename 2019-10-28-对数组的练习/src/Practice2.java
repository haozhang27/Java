
import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/28
 */
public class Practice2 {
    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，
     * 找出 0 .. n 中没有出现在序列中的那个数。
     * @param nums 要判断的数组
     * @return -1 表示不差任何数字；其他表示没有出现的树
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }

        if (nums[0] != 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                return nums[i] - 1;
            }
        }
        return -1;
    }
}
