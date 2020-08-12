import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定n个字符串，请对n个字符串按照字典序排列。
 *
 * @author haozhang
 * @date 2020/08/12
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt((sc.nextLine()));
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLine();
            }
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
