import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度大于2的子串重复
 *
 * 如果符合要求输出：OK，否则输出NG
 * @author haozhang
 * @date 2020/08/13
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.length() > 8 && isInclude(s) && isSubstring(s)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    private static boolean isInclude(String s) {
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

    private static boolean isInc(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        } else if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= '0' && c <= '9') {
            return true;
        }

        return false;
    }

    private static boolean isSubstring(String s) {
        for (int i = 0; i < s.length() - 3; i++) {
            if (s.substring(i + 3, s.length()).contains(s.substring(i, i + 3))) {
                return false;
            }
        }
        return true;
    }
}
