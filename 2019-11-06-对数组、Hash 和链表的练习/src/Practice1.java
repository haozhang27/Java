
import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/06
 */
public class Practice1 {
    /**
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     *
     * 	数字 1-9 在每一行只能出现一次。
     * 	数字 1-9 在每一列只能出现一次。
     * 	数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     *
     * @param board 要判断的数组
     * @return true 表示有效； false 表示无效
     */
    public boolean isValidSudoKu(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isRow(board, i) || !isCol(board ,i) || !isRowCol(board)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断 该行上的数是否都只出现一次
     * @param arr 要判断的数组
     * @param row 要判断的行
     * @return true 表示都出现一次；false 表示不都只出现一次
     */
    private boolean isRow(char[][] arr, int row) {
        Map<Character, Integer> map = new HashMap<>(16);
        char[] a = arr[row];

        if (!isOnce(a)) {
            return false;
        }

        return true;
    }

    /**
     * 判断 该列上的数是否都出现一次
     * @param arr 要判断的数组
     * @param col 要判断的行
     * @return true 表示都出现一次； false 表示不都只出现一次
     */
    private boolean isCol(char[][] arr, int col) {
        Map<Character, Integer> map = new HashMap<>(16);
        char[] a = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i][col];
        }

        if (!isOnce(a)) {
            return false;
        }
        return true;
    }

    /**
     * 判断 宫格内的数是否都只出现一次
     * @param arr 要判得的数组
     * @return true 表示都出现一次； false 表示不都只出现一次
     */
    private boolean isRowCol(char[][] arr) {
        char[] a = new char[arr.length];
        int k = 0;
        while (k <= 6) {
            a = display(arr, k, 0);
            if (!isOnce(a)) {
                return false;
            }
            k += 3;
        }

        int m = 0;
        while (m <= 6) {
            a = display(arr, m, 3);
            if (!isOnce(a)) {
                return false;
            }
            m += 3;
        }

        int q = 0;
        while (q <= 6) {
            a = display(arr, q, 6);
            if (!isOnce(a)) {
                return false;
            }
            q += 3;
        }

        return true;
    }

    /**
     * 判断数组中的数是否的只出现一次
     * @param a 要判得的数组
     * @return true 表示都出现一次； false 表示不都出现一次
     */
    private boolean isOnce(char[] a) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < a.length; i++) {
            int c = map.getOrDefault(a[i], 0);
            map.put(a[i], c + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (key >= '1' && key <= '9' && val > 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * 遍历宫格内的数
     * @param arr 遍历的数组
     * @param i 遍历的行位置
     * @param j 遍历的列位置
     * @return 遍历好的数组
     */
    private char[] display(char[][] arr, int i, int j) {
        char[] ret = new char[arr.length];
        int count = 0;
        for (int i1 = i; i1 < i + 3; i1++) {
            for (int j1 = j; j1 < j + 3; j1++) {
                ret[count++] = arr[i1][j1];
            }
        }
        return ret;
    }
}
