/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/24
 */
public class Practice1 {
    /**
     * 删除 nums 中所有的 val
     * @param nums 要进行删除操作的数组
     * @param val 要删除的值
     * @return 数组中剩余元素个数
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
