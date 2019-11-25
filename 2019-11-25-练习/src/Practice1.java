import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/25
 */
public class Practice1 {
    public int countOfGread() {
        Scanner sc = new Scanner(System.in);
        int ret = 0;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int num = sc.nextInt();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == num) {
                    ret++;
                }
            }
        }

        return ret;
    }
}
