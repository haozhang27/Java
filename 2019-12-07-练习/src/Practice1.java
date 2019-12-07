import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Practice1 {
    /**
     * 在 arr中查找element
     * @param arr 给定的数组
     * @param element 要查找的值
     * @return -1表示不存在；其他表示存在
     */
    public int index(int[] arr, int element) {
        Arrays.sort(arr);
        int front = 0;
        int last = arr.length;
        while (front < last) {
            int mid = front +  (last - front) / 2;
            if (arr[mid] > element) {
                last = mid;
            } else if (arr[mid] < element) {
                front = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
