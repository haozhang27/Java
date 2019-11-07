/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/07
 */
public class Practice1 {
    /**
     * 判断是否为数独
     * @param board 存放数据的数组
     * @return false 表示不是； true 表示是
     */
    public boolean isValidSuDoKu (char[][] board) {
        int[] hashRow = new int[9];
        int[] hashCol = new int[9];
        int[] hash = new int[9];

        for (int i = 0; i < board.length; i++) {
            hashRow = new int[9];
            hashCol = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (hashRow[board[i][j] - '1'] == 0) {
                        hashRow[board[i][j] - '1'] = 1;
                    } else {
                        return false;
                    }
                }

                if (board[j][i] != '.') {
                    if (hashCol[board[j][i] - '1'] == 0) {
                        hashCol[board[j][i] - '1'] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                hash = new int[9];
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[i + m][j + n] != '.') {
                            if (hash[board[i + m][j + n] - '1'] == 0) {
                                hash[board[i + m][j + n] - '1'] = 1;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
