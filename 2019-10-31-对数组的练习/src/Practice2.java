/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/31
 */
public class Practice2 {
    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数
     * @param nums 给定的数组
     * @return 最大连续1的个数
     */
    public int findMaxConsectiveOnes(int[] nums) {
        int ret = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                num++;
            } else {
               ret = num > ret ? num : ret;
                num = 0;
            }
        }
        return ret > num ? ret : num;
    }
}
