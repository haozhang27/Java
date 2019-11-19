
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/19
 */
public class Practice1 {
    /**
     * 给 n 个瓶子换汽水，三个空瓶可换一瓶汽水
     * @param n 瓶子数
     * @return 可换得汽水的数
     */
    public int drink(int n) {
        int ret = 0;

        while (n > 2) {
            ret = ret + n / 3;

            n = n / 3 + n % 3;
        }

        if (n == 2) {
            ret = ret + 1;
        }

        return ret;
    }
}
