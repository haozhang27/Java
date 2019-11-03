/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/03
 */
public class Practice1 {
    /**
     * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数
     * @param nums 给定的数组
     * @param k 最大长度
     * @return 最大平均数
     */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double t = sum;
        for (int i = 1; i < nums.length - k + 1; i++) {
            t = t - nums[i - 1] + nums[i + k - 1];
            sum = Math.max(t, sum);
        }
        return sum / k;
    }
}
