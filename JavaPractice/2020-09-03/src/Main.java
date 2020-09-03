import java.util.Scanner;

/**
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 *
 * @author haozhang
 * @date 2020/09/03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(getSameStr(s1, s2));
        }
    }

    public static String getSameStr(String s1, String s2) {
        String max = s1.length() > s2.length() ? s1 : s2;
        String min = s1.length() < s2.length() ? s1 : s2;
        for (int i = 0; i < min.length(); i++) {
            for (int j = 0, k = min.length() - i; k < min.length(); j++, k++) {
                String s = min.substring(j, k);
                if (max.contains(s)) {
                    return s;
                }
            }
        }
        return null;
    }
}
