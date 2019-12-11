
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/11
 */
public class Practice2 {
    public void bigNumberSort() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            BigInteger[] nums = new BigInteger[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextBigInteger();
            }

            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
        }
    }
}
