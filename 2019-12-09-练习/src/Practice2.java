/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/09
 */
public class Practice2 {
    /**
     * 今年公司年会的奖品特别给力，但获奖的规矩却很奇葩：
     *  1. 首先，所有人员都将一张写有自己名字的字条放入抽奖箱中；
     *  2. 待所有字条加入完毕，每人从箱中取一个字条；
     *  3. 如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了！”
     *  现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？
     * @param n 给定的人数
     * @return 无人获奖的概率
     */
    public void probabilityOfNotWin(int n) {
        double ret = count(n) / factorial(n);
        System.out.printf("%.2f", ret * 100);
    }

    /**
     * 求未抽到的人数总数
     * @param n 总人数
     * @return 未抽到的人数总和
     */
    private double count(double n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        return (n - 1) * (count(n - 1) + count(n - 2));
    }

    /**
     * n的阶乘
     * @param n 给定的总人数
     * @return n 的阶乘
     */
    private double factorial(double n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
