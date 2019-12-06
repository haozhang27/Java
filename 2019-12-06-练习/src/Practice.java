import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/06
 */
public class Practice {
    static Map<Integer, Integer> count(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int n : numbers) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }

        /*
         * keySet();   取出所有的 key 所有的数字
         * values();    取出所有的 value 所有的出现次数
         * entrySet();  所有的 数字及其出现次数的键值对
         *
         */

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            if (cnt == 1) {
                System.out.println(num);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 5, 7, 3, 2, 1};
        System.out.println(count(array));
    }
}
