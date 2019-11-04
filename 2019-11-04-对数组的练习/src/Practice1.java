/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/04
 */
public class Practice1 {
    /**
     * 转置矩阵
     * @param A 要转置的矩阵
     * @return 转置后的矩阵
     */
    public int[][] transpose(int[][] A) {
        int[][] ret = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                ret[i][j] = A[j][i];
            }
        }
        return ret;
    }
}
