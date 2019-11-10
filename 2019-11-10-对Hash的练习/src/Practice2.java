import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/10
 */
public class Practice2 {
    /**
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     * 返回重复了 N 次的那个元素
     * @param A 按寻找的数组
     * @return 重复 N 次的元素
     */
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            int n = map.getOrDefault(A[i], 0);
            map.put(A[i], n + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val != 1) {
                ret = key;
            }
        }

        return ret;
    }
}
