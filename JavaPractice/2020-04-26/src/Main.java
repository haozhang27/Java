import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/04/26
 */
public class Main {

    /**
     * 数组中只出现两个奇数次的数字  找出来
     * @param arr
     * @return
     */
    public static int[] getArr(int[] arr) {
        int[] ret = new int[2];
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < arr.length; i++) {
            int n = map.getOrDefault(arr[i], 0);
            map.put(arr[i], n + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 == 1) {
                ret[j++] = key;
            }
        }
        Arrays.sort(ret);
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                System.out.println(getIndex(arr, num, i, true) + " " +
                        getIndex(arr, num, i, false));
            }
        }
    }

    /**
     * 给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置
     * 最近且值比 arr[i] 小的位置。返回所有位置相应的信息。
     * @param arr
     * @param num
     * @param i
     * @param isLeft
     * @return
     */
    public static int getIndex(int[] arr, int num, int i, boolean isLeft) {
        if (isLeft) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] < num) {
                    return j;
                }
            }
        } else {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < num) {
                    return j;
                }
            }
        }
        return -1;
    }
}
