
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Main {
    /**
     *一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * @param target 台阶的阶数
     * @return 跳上target数的台阶有多少种跳法
     */
    public static int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }

        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项
     * （从0开始，第0项为0）。
     * n<=39
     * @param n 斐波那契数的项数
     * @return 斐波那契数列的第n项
     */
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(5));
        System.out.println(fibonacci(5));
    }
}
