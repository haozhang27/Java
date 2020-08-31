import java.util.Scanner;

/**
 * 计算整数二进制中1的个数
 *
 * @author haozhang
 * @date 2020/08/31
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            System.out.println(findNumberOf1(num));
        }
    }

    public static int findNumberOf1( int num) {
        String s = Integer.toBinaryString(num);
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ret++;
            }
        }

        return ret;

    }
}
