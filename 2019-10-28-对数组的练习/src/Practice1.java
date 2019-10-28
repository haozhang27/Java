import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/28
 */
public class Practice1 {
    /**
     * 判断数组中是否存在重复元素
     * @param nums 要判断的数组
     * @return true 表示存在重复元素；false 表示不存在
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int n = map.getOrDefault(num, 0);
            map.put(num, n + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val != 1) {
                return true;
            }
        }
        return false;
    }
}
