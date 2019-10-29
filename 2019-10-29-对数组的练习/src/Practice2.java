/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/29
 */
public class Practice2 {
    public int binarySearch(int[] arr, int key) {
        int front = 0;
        int last = arr.length - 1;
        while (front <= last) {
            int mid = front + (last - front) / 2;
            if (key < arr[mid]) {
                last = mid;
            } else if (key > arr[mid]) {
                front = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
