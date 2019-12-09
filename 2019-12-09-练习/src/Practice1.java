import java.math.BigInteger;
import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/09
 */
public class Practice1 {
    /**
     * 大整数排序，对N个长度最长可达到1000的数进行排序
     * @param arr 给定的字符串数组
     * @return 排序好的数组
     */
    public String[] sort (String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (stringSort(arr[i], arr[j])) {
                    swap(arr, i, j);
                }
            }
        }

        return arr;
    }

    private void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 比较两个字符串的大小
     * @param s1
     * @param s2
     * @return
     */
    private boolean stringSort(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return true;
        } else if (s1.length() < s2.length()) {
            return false;
        } else {
            if (s1.compareTo(s2) > 0) {
                return true;
            }
        }
        return false;
    }

    public BigInteger[] sort2(BigInteger[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}
