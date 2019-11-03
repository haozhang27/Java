import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/03
 */
public class Practice2 {
    /**
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积
     * @param nums 给定的数组
     * @return 最大乘积
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
