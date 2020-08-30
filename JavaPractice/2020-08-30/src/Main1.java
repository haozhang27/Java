import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入n个数  输出最小的k个
 *
 * @author haozhang
 * @date 2020/08/30
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            getMin(arr, k);

        }
    }

    public static void getMin(int[] arr, int k) {
        Arrays.sort(arr);
        if (k <= arr.length) {
            for (int i = 0; i < k;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < arr.length;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
