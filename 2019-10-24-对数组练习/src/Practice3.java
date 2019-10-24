/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/24
 */
public class Practice3 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }

            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
