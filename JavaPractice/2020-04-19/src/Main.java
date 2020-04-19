/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/04/19
 */
public class Main {
    /**
     * 长度为n的数组乱序存放着0至n-1. 现在只能进行0与其他数的swap，请设计并实现排序。
     * @param arr
     * @param len
     */
    public static void swapWithZero(int[] arr, int len) {
        if (arr == null || len < 1) {
            return;
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] != i) {
                swap(arr, 0, i);
                sort(arr, len);
            }
        }

    }

    private static void sort(int[] arr, int len) {
        if (arr == null || len < 1) {
            return;
        }

        while (arr[0] != 0) {
            swap(arr, 0, arr[0]);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 假设第一天量产1台，接下来2天(即第二、三天)每天量产2件，接下来3天(即第四、五、六天)每天量产3件 ... ...
     * 计算出第n天总共可以量产的手机数量。
     * @param n
     * @return
     */
    public static int solution (int n) {
        int days = 0;
        int count = 0;
        while (days < n) {
            for (int i = 1; i < n; i++) {
                if (days < n) {
                    days += i;
                    count++;
                }
            }
        }
        int num = count - (days - n);
        int ret = 0;
        for (int i = 1; i < count; i++) {
            ret += i * i;
        }
        ret += num * count;
        return ret;
    }
}
