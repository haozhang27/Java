
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/10
 */
public class Practice2 {
    /**
     * 对于给定的正整数 n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和。
     */
    public String sumOfNum(int a) {
        StringBuilder sb = new StringBuilder();
        int b = a * a;
        sb.append(add(a));
        sb.append(" ");
        sb.append(add(b));
        return sb.toString();
    }

    private int add(int a) {
        int sum = 0;
        while (a != 0) {
            sum = sum + a % 10;
            a /= 10;
        }
        return sum;
    }
}
