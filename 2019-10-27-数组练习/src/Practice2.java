import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/27
 */
public class Practice2 {
    /**
     * 给定一个大小为 n 的数组，找到其中的众数。
     * 众数是指在数组中出现次数大于 [ n/2 ] 的元素。
     * @param nums 要寻找众数的数组
     * @return 找到的众数
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int n = map.getOrDefault(num, 0);
            map.put(num, n + 1);
        }

        int retValue = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > retValue) {
                retValue = value;
                max = key;
            }
        }
        return max;
    }
}
