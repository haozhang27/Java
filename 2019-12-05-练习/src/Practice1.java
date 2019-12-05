/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Practice1 {
    /**
     * 对于给定的正整数 n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和。
     * @param n 给定的整数
     */
    public void countOfNums(int n) {
        int num1 = n;
        int num2 = n * n;
        int ret = 0;
        while (num1 > 0) {
            int num = num1 % 10;
            ret += num;
            num1 = num1 / 10;
        }

        int ret2 = 0;
        while (num2 > 0) {
            int num = num2 % 10;
            ret2 += num;
            num2 = num2 / 10;
        }

        System.out.println(ret + " " + ret2);
    }
}
