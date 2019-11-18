import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/18
 */
public class Practice1 {
    /**
     * 给定一个数组，找出数组中出现元素个数大于等于数组长度一半的元素
     * @param arr 给定数组
     * @return 元素个数大于等于数组长度一半的元素
     */
    public int countOfNum(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int num = map.getOrDefault(key, 0);
            map.put(key, num + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val >= arr.length / 2) {
                ret = key;
            }
        }

        return ret;
    }
}
