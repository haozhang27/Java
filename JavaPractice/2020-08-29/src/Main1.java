import java.util.Scanner;

/**
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 * 给定函数count(int n),用于计算n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
 * 返回n以内完全数的个数。 异常情况返回-1
 *
 * @author haozhang
 * @date 2020/08/29
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(getCount(num));
        }
    }

    public static int getCount(int num) {
        int count = 0;
        for (int i = 1; i < num; i++) {
            if (isComplete(i)) {
                count++;
            }
        }
        if (count == 0) {
            return -1;
        }

        return count;
    }

    public static boolean isComplete(int n) {
        int sum = 0;
        for (int i = 1; i < n / 2 + 1; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        if (sum == n) {
            return true;
        }

        return false;
    }
}
