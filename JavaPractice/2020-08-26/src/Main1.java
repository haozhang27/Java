import java.util.Scanner;

/**
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数
 *
 * @author haozhang
 * @date 2020/08/26
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            getCounts(s);
        }
    }

    public static void getCounts(String s) {
        int letter = 0;
        int space = 0;
        int number = 0;
        int other = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <='Z') {
                letter++;
            } else if (c == ' ') {
                space++;
            } else if (c >= '0' && c <= '9') {
                number++;
            } else {
                other++;
            }
        }
        System.out.println(letter);
        System.out.println(space);
        System.out.println(number);
        System.out.println(other);
    }
}
