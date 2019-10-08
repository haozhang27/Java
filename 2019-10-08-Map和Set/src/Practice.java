import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/08
 */
public class Practice {
    /**
     * 寻找一个数组中只出现一次的数
     * @param array 要寻找的数组
     * @return 找到 返回该数，未找到返回 -1
     */
    public static int singleNumber(int[] array) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int n : array) {
            int c = map.getOrDefault(n, 0);
            map.put(n, c + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            int cont = entry.getValue();
            if (cont == 1) {
                return val;
            }
        }

        return -1;
    }

    private static int numsInString(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        int cont = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                cont++;
            }
        }

        return cont;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 1, 2, 4};
        System.out.println(singleNumber(array));

        String s = "aA";
        String j = "aaAAAbbBB";
        System.out.println(numsInString(s, j));

    }
}
