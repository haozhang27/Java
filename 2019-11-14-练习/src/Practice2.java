import java.util.Arrays;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/14
 */
public class Practice2 {
    /**
     * 输入一组数据，找出前 K 小，按照升序输出
     * k 是输入的数据中的最后一个
     */
    public void numberOfFront() {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toString();
        String[] arr = str.split(" ");
        int[] ret = new int[arr.length];
        for (int i = 0; i < ret.length; i++) {
            int n = Integer.parseInt(arr[i]);
            ret[i] = n;
        }

        int num = ret[ret.length - 1];
        int[] retNumber = Arrays.copyOfRange(ret, 0, ret.length - 1);
        Arrays.sort(retNumber);

        for (int i = 0; i < num; i++) {
            System.out.print(retNumber[i] + " ");
        }
    }
}
