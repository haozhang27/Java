/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/24
 */
public class Practice1 {
    /**
     * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，
     * 要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法
     * @param x 给定的行数
     * @param y 给定的列数
     * @return 走法的总数
     */
    public int countWays(int x, int y) {
        if (x == 1 || y == 1) {
            return 1;
        }

        return countWays(x - 1, y) + countWays(x, y - 1);
    }
}
