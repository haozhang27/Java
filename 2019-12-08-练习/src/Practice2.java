import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/08
 */
public class Practice2 {
    /**
     * 判断一个密码是否为合格密码
     * 1.长度超过8位
     * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     * 3.不能有相同长度超2的子串重复
     * @param s 给定的密码
     * @return true表示是合格密码；false表示不是
     */
    public boolean isQualifiedPassWord(String s) {
        if (s.length() > 8 && isInclude(s) && isSubstring(s)) {
            return true;
        }
        return false;
    }

    /**
     * 判断该字符串是否包含大小写字母.数字.其它符号,以上四种至少三种
     * @param s 给定的字符串
     * @return true表示包含；false表示不包含
     */
    private boolean isInclude(String s) {
        char[] arr = s.toCharArray();
        List<Character> upperChars = new ArrayList<>();
        List<Character> lowerChars = new ArrayList<>();
        List<Character> nums = new ArrayList<>();
        List<Character> other = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z' && upperChars.size() < 1) {
                upperChars.add(c);
            } else if (c >= 'a' && c <= 'z' && lowerChars.size() < 1) {
                lowerChars.add(c);
            } else if (c >= '0' && c <= '9' && nums.size() < 1) {
                nums.add(c);
            } else if (!isInc(c) && other.size() < 1) {
                other.add(c);
            }
        }

        if ((upperChars.size() + lowerChars.size() + nums.size() + other.size()) >= 3) {
            return true;
        }

        return false;
    }

    /**
     * 判断一个字符是否是不是除了大小写字母、数字、以外的字符
     * @param c 给定的字符
     * @return true表示是；false表示不是
     */
    private boolean isInc(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        } else if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= '0' && c <= '9') {
            return true;
        }

        return false;
    }

    /**
     * 判断一个字符串是否有相同长度超2的子串
     * @param s 给定的字符串
     * @return true表示有；true表示没有
     */
    private boolean isSubstring(String s) {
        for (int i = 0; i < s.length() - 3; i++) {
            if (s.substring(i + 3, s.length()).contains(s.substring(i, i + 3))) {
                return false;
            }
        }
        return true;
    }
}
