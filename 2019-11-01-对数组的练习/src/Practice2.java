import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/01
 */
public class Practice2 {
    /**
     * 找出数组中的重复元素
     * @param nums 要寻找的数组
     * @return 重复元素所构成的数组
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
