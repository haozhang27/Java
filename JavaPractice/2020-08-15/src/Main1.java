import java.util.Scanner;

/**
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e 输出： Be?y
 *
 * @author haozhang
 * @date 2020/08/15
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(sortStr(s));
        }
    }

    public static String sortStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (int j = 65; j <= 91; j++) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (j == c || j == c - 32) {
                    sb.append(c);
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isChar(c)) {
                sb.insert(i, c);
            }
        }


        return sb.toString();
    }

    public static boolean isChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }

        if (c >= 'A' && c <= 'Z') {
            return true;
        }

        return false;
    }
}
