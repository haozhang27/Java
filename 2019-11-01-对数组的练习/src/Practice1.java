import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/01
 */
public class Practice1 {
    /**
     * 找出数组中的第三大的数字；如果没有返回最大的数字
     * @param nums 要判断的数组
     * @return 第三大数字 或者 最大数字
     */
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int j = 1;
        int conditionNum = 3;
        arr[0] = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i]) {
                arr[j] = nums[i + 1];
                j++;
            }
        }

        if (j < conditionNum) {
            return arr[j - 1];
        }

        return arr[j - conditionNum];
    }
}
