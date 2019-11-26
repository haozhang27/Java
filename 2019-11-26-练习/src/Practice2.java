/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/26
 */
public class Practice2 {
    public int countOfCakes(int row, int col) {
        int evenCount = (col / 4) * 2 + (col % 4 < 2 ? col % 4 : 2);
        int oddCount = ((col - 2)) / 4 * 2 + ((col - 2) % 4 < 2 ? (col - 2) % 4 : 2);

        int ret = (row / 4) * (evenCount + oddCount) * 2;
        if (row % 4 > 0) {
            ret += evenCount;
        }

        if (row % 4 > 1) {
            ret += evenCount;
        }

        if (row % 4 > 2) {
            ret += oddCount;
        }

        return ret;
    }
}
