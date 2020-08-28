import java.util.Scanner;

/**
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，
 * 输出为按字节截取的字符串。但是要保证汉字不被截半个，
 * 如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，
 * 应该输出为"我ABC"而不是"我ABC+汉的半个"。
 *
 * @author haozhang
 * @date 2020/08/28
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] arr = sc.nextLine().split(" ");
            int n = Integer.parseInt(arr[1]);
            System.out.println(getStr(arr[0], n));
        }
    }

    public static String getStr(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count += 1;
                if (count > n) {
                    return sb.toString();
                }
                sb.append(c);
            } else {
                count += 2;
                if (count > n) {
                    return sb.toString();
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
