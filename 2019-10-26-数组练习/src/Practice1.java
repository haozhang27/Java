/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/26
 */
public class Practice1 {
    /**
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），
     * 设计一个算法来计算你所能获取的最大利润。
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * @param prices 给定的数组
     * @return 0 表示没有合适的买入时机；其他表示可获得的最大利润
     */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }
}
