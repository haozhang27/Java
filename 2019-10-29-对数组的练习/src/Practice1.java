/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/29
 */
public class Practice1 {
    /**
     * 数组逆置
     * @param arr 要逆置的数组
     * @return 逆置后的数组
     */
    public int[] changeArray(int[] arr) {
        int front = 0;
        int last = arr.length - 1;
        int temp;
        while (front <= last) {
            temp = arr[front];
            arr[front] = arr[last];
            arr[last] = temp;
            front++;
            last--;
        }
        return arr;
    }
}
