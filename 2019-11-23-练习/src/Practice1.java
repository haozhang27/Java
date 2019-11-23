/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/23
 */
public class Practice1 {
    /**
     * 输出一个数的立方由哪些奇数的和组成
     * @param m 给定的数
     * @return 和的组成奇数
     */
    public String getSequeOddNum(int m) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < m; i++) {
            num += i;
        }

        for (int i = 0; i < m; i++) {
            int ret = 2 * num + 1;
            num++;
            sb.append(ret);
            if (i < m - 1) {
                sb.append("+");
            }
        }

        return sb.toString();
    }
}
