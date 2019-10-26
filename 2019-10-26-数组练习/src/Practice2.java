/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/26
 */
public class Practice2 {
    /**
     * 斐波那契数列
     * @param N 第几项
     * @return 斐波那契的第 N 项
     */
    public int fib(int N) {
        int cur = 0;
        int next = 1;
        while (N-- > 0) {
            next = next + cur;
            cur = next - cur;
        }
        return cur;
    }
}
