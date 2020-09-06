import java.util.Scanner;

/**
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * 例如：
 * 1^3=1
 * 2^3=3+5
 * 3^3=7+9+11
 * 4^3=13+15+17+19
 *
 * @author haozhang
 * @date 2020/09/06
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            System.out.println(getSequeOddNum(num));
        }
    }

    public static String getSequeOddNum(int num) {
        StringBuilder sb = new StringBuilder();
        int begin = (num - 1) * num + 1;
        for (int i = 0; i < num; i ++) {
            sb.append(begin);
            if (i != num - 1) {
                sb.append("+");
            }
            begin += 2;
        }
        return sb.toString();
    }
}
