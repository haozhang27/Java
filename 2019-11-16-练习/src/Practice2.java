import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/16
 */
public class Practice2 {
    /**
     * 求最小公倍数
     *      1.两个数互除，如果 a % b = 0， 最小公倍数为 a
     *      2.寻找最大公因数，最小公倍数等于 a * b / 最大公因数
     *      3.如果 a 和 b 的最大公因数为 1，那么最小公倍数为 a * b
     * @param a 数字 a
     * @param b 数字 b
     * @return a 和 b 的最小公倍数
     */
    public int lowestCommonMultiple(int a, int b) {
        if (a % b == 0) {
            return a;
        }

        if (b % a == 0) {
            return b;
        }

        Set<Integer> set1 = new HashSet<>();
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                set1.add(i);
                set1.add(a % i);
            }
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i = 1; i <= b; i++) {
            if (b % i == 0) {
                set2.add(i);
                set2.add(b % i);
            }
        }

        Object[] arr1 = new Object[set1.size()];
        Object[] arr2 = new Object[set1.size()];
        arr1 =  set1.toArray();
        arr2 = set2.toArray();

        int num = 0;
        for (int i = 0; i < set1.size(); i++) {
            int num1 = (int)arr1[i];
            for (int j = 0; j < set2.size(); j++) {
                int num2 = (int)arr2[j];
                if (num1 == num2) {
                    num = Math.max(num, num1);
                }
            }
        }

        if (num == 1) {
            return a * b;
        }

        return a * b / num;
    }
}
