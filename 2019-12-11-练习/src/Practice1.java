/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/11
 */
public class Practice1 {
    /**
     *输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数(如'3’，输出：10110011)
     * @param chars 给定的字符数组
     */
    public void oddParity(char[] chars) {
        int[] ret = new int[8];
        for (int i = 0; i < chars.length; i++) {
            int n = 0x01;
            int j = 7;
            int sum = 0;
            while (j > 0) {
                ret[j] = (chars[i] & n) == 0 ? 0 : 1;
                if (ret[j] == 1) {
                    sum++;
                }
                n = n << 1;
                j--;
            }

            if ((sum & 1) == 0) {
                ret[0] = 1;
            }
            for (int k = 0; k < ret.length; k++) {
                System.out.print(ret[k]);
            }
            ret[0] = 0;
            System.out.println();
        }
    }
}
