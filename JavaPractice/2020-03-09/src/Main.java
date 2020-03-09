/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/09
 */
public class Main {
    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * @param n 整数
     * @return 1的个数
     */
    public static int  numberOf1(int n) {
        String str = Integer.toBinaryString(n);
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '1') {
                ret++;
            }
        }
        return ret;
    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。
     * 求base的exponent次方。
     *
     * 保证base和exponent不同时为0
     * @param base
     * @param exponent
     * @return
     */
    public static double power(double base, int exponent) {
        double ret = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                ret *= base;
            }
        }

        if (exponent < 0) {
            for (int i = exponent; i < 0; i++) {
                ret /= base;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(15));
        System.out.println(power(2, 4));
    }

}
