/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/18
 */
public class CharacterMatch {
    /**
     * 暴力匹配
     * 字符串匹配问题
     * @param haystack 主字符串
     * @param needle 模式字符串
     * @return -1 表示不能匹配；其他表示匹配成功，needle 中字符的个数
     */
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();

        if (h < n) {
            return -1;
        }

        /**
         * 这里 + 1，主要是为了判断 "a" "a" 这种情况
         */
        for (int i = 0; i < h - n + 1; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }


    public int strStr1(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
