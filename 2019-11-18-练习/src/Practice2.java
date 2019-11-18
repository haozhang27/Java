import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/18
 */
public class Practice2 {
    /**
     * 选择物品不同的方式
     * @return 不同方式
     */
    public int numOfGet() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        return count(arr, n, 40);
    }

    private int count(int[] arr, int i, int s) {
        if (s == 0) {
            return 1;
        } else if (i == 1) {
            if (arr[i] == s) {
                return 1;
            } else {
                return 0;
            }
        } else if (arr[i] > s) {
            return count(arr, i - 1, s);
        }

        return count(arr, i - 1, s- arr[i]) + count(arr, i - 1, s);
    }
}
