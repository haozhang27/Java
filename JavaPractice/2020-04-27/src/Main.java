import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/04/27
 */
public class Main {
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
     * 请找出这两个只出现一次的数字。
     * @param arr
     * @return
     */
    public int[] findNumsAppearOnce(int [] arr) {
        return findNum(arr);
    }

    public int[] findNum(int[] arr) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int n = map.getOrDefault(num, 0);
            map.put(num, n + 1);
        }

        int k = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val == 1) {
                ret[k++] = key;
            }
        }
        return ret;
    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     * @param arr
     * @param k
     * @return
     */
    public static int getNumberOfK(int[] arr, int k) {
        //如果是降序
        if (arr.length != 0 && arr[0] > arr[arr.length - 1]) {
            Arrays.sort(arr);
        }

        int frontIndex = getFrontIndex(arr, k);
        if (frontIndex == -1) {
            return 0;
        }

        //lastIndex有可能是-1
        int lastIndex = getLastIndex(arr, k, frontIndex);
        if (lastIndex == -1) {
            return 0;
        }
        return lastIndex - frontIndex + 1;
    }

    /**
     * 获取 k 第一次出现的位置
     * @param arr
     * @param k
     * @return
     */
    public static int getFrontIndex(int[] arr, int k) {
        int front = 0;
        int last = arr.length - 1;
        while (front <= last) {
            int mid = front + (last - front) / 2;
            if (arr[mid] < k) {
                front = mid + 1;
            } else if (arr[mid] > k) {
                last = mid - 1;
            } else {
                if (mid > 0 && arr[mid - 1] != k) {
                    return mid;
                } else if (mid == 0) {
                    return mid;
                } else {
                    last = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 获取k最后一次出现的位置
     * @param arr
     * @param k
     * @param frontIndex
     * @return
     */
    public static int getLastIndex(int[] arr, int k, int frontIndex) {
        int front = frontIndex;
        int last = arr.length - 1;
        while (front <= last) {
            int mid = front + (last - front) / 2;
            if (arr[mid] < k) {
                front = mid + 1;
            } else if (arr[mid] > k) {
                last = mid - 1;
            } else {
                if (mid < arr.length - 1 && arr[mid + 1] != k) {
                    return mid;
                } else if (mid == arr.length - 1) {
                    return mid;
                } else {
                    front = mid + 1;
                }
            }
        }
        return -1;
    }
}
