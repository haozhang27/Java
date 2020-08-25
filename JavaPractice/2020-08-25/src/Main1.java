import java.util.Scanner;

/**
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，
 * 共经历多少米?第5次反弹多高？
 *
 * 最后的误差判断是小数点6位
 *
 * @author haozhang
 * @date 2020/08/25
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()) {
            double n = sc.nextDouble();
            System.out.println(getSum(n));
            System.out.println(getHigh(n));
        }
    }

    public static double getHigh(Double n) {
        return n / Math.pow(2, 5);
    }

    public static double getSum(Double n) {
        int num = 5;
        double sum = 0;
        while (num > 0) {
            sum += n / Math.pow(2, 5 - num);
            if (6 - num >= 0 && 6 - num < 5) {
                sum += n / Math.pow(2, 6 - num);
            }
            num--;
        }
        return sum;
    }
}
