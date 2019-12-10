import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/10
 */
public class Practice1 {
    /**
     * 给定一个数组和一个sum，求这个数组中的元素有多少种可能组成sum，
     * 数组元素不可重复使用
     */
    public void countOfSum() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            for (int j = sum; j >= 0; j--) {
                if (j >= arr[i]) {
                    dp[j] += dp[j - arr[i]];
                }
            }
        }
        System.out.println(dp[sum]);
    }
}
