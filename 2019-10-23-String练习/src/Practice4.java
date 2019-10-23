/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/23
 */
public class Practice4 {
    /**
     * 给定两个单词 word1 和 word2，找到使得 word1 和 word2
     * 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
     * @param word1 要操作的单词
     * @param word2 要操作的单词
     * @return 使两个字符串相同所需的最小步数
     */
    public int minDistance(String word1, String word2) {
        int[][] arr = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j== 0) {
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        return word1.length() + word2.length() - 2*arr[word1.length()][word2.length()];
    }
}
