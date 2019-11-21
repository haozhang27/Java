/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/21
 */
public class Practice2 {
    /**
     * 输入一个正整数n,求n!(即阶乘)末尾有多少个0
     * @param n 输入的整数
     * @return 末尾 0 的个数
     */
    public int countsOfZeros(int n) {
        int ret = 0;
        for (int i = n; i >= 5; i--) {
            int tem = i;
            while (tem % 5 == 0) {
                ret++;
                tem /= 5;
            }
        }
        return ret;
    }
}
