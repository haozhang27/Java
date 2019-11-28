import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/28
 */
public class Practice1 {
    /**
     *找出红包中出现次数超过总数一半的
     * @param gifts 红包出现数组
     * @param n 红包总个数
     * @return 出现次数超过一半的红包
     */
    public int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            int num = map.getOrDefault(gifts[i], 0);
            map.put(gifts[i], num + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val > (n / 2)) {
                return key;
            }
        }

        return 0;
    }
}
