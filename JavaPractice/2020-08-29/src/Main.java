import java.util.Scanner;

/**
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数
 * 字（如17，27，37...70，71，72，73...）的个数（一组测试用例里可能有多组数据，请注意处理）
 *
 * @author haozhang
 * @date 2020/08/29
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(getCount(n));
        }
    }

    public static int getCount(int n) {
        int count = 0;
        String s = null;
        for (int i = 7; i <= n; i++) {
            s = String.valueOf(i);
            if (s.contains("7") || i % 7 == 0) {
                count++;
            }
        }
        return count;
    }
}
