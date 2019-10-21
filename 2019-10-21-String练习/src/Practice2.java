/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/21
 */
public class Practice2 {
    /**
     * 全部字母都是大写，比如"USA"。
     * 单词中所有字母都不是大写，比如"java"。
     * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
     *
     * 否则，我们定义这个单词没有正确使用大写字母。
     *
     * @param word 要判断的单词
     * @return true 表示符合定义；false 表示不符合
     */
    public boolean detectCapitalUse(String word) {
        char[] ret = word.toCharArray();
        int upper = 0;
        int lower = 0;

        for (int i = 0; i < ret.length; i++) {
            if (ret[i] - 'a' < 0) {
                upper++;
            } else {
                lower++;
            }
        }

        if (upper == ret.length) {
            return true;
        }

        if (lower == ret.length) {
            return true;
        }

        if (upper == 1 && ret[0] < 'a') {
            return true;
        }

        return false;
    }
}
