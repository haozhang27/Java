import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/17
 */
public class Practice {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""
     * @param strs 输入的字符串数组
     * @return "" 表示没有公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }

            ans = ans.substring(0, j);
            if (ans.equals("")) {
                return ans;
            }
        }

        return ans;
    }



    public static int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        int str = 0;
        int end = needle.length() - 1;
        while (end < haystack.length()) {
            if (haystack.substring(str, end + 1).equals(needle)) {
                return str;
            }
            end++;
            str++;
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] strs = new String[] {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));


        String hayStack = "hello";
        String needle = "ll";
        System.out.println(strStr(hayStack, needle));


    }
}
