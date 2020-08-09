import java.util.Scanner;

/**
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * @author haozhang
 * @date 2020/08/09
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            getNewStr(s);
        }

    }

    public static void getNewStr(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 8) {
            System.out.println(sb.toString().substring(0, 8));
            sb.delete(0, 8);
        }

        addZeros(sb.toString());
    }

    public static void addZeros(String s) {
        if (s.length() == 8) {
            System.out.println(s);
        }

        if (s.length() < 8) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = sb.length(); i < 8; i++) {
                sb.append(0);
            }
            System.out.println(sb.toString());
        }
    }
}
