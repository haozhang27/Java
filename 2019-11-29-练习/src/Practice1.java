/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/29
 */
public class Practice1 {
    /**
     * 一只兔子每月生一只兔子，新生的兔子三个月之后也可生兔子，假设兔子不死，求 n 月之后兔子书
     * @param monthCount 月份
     * @return monthCount 月之后兔子的数量
     */
    public int getTotalCount(int monthCount) {
        int a = 1;
        int b = 1;
        int c = 1;

        for (int i = 2; i < monthCount; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
