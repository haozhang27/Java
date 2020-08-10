import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * @author haozhang
 * @date 2020/08/10
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(getNumbers(s));
        }
    }

    public static String getNumbers(String s) {
        Set<Character> set = new LinkedHashSet<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            set.add(c);
            if (set.size() == 10) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : set) {
            sb.append(c);
        }
        return sb.toString();
    }
}
