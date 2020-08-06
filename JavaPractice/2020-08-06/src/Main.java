import java.util.Scanner;
/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 *
 * @author haozhang
 * @date 2020/08/06
 */
public class Main {

    static char[] CHARS = new char[] {'A', 'B', 'C', 'D', 'E', 'F'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int count = 0;
            int ret = 0;
            for (int i = str.length() - 1; i > 1; i--) {
                char c = str.charAt(i);
                int num = 0;
                if (c >= 'A') {
                    num = getNum(c);
                    ret += Math.pow(16, count) * num;
                    count++;
                } else {
                    num = str.charAt(i) - 48;
                    ret += Math.pow(16, count) * num;
                    count++;
                }
            }
            System.out.println(String.valueOf(ret));
        }
    }

    private static int getNum(char c) {
        int num = 0;
        if (c == CHARS[0]) {
            num = 10;
            return num;
        } else if (c == CHARS[1]) {
            num = 11;
            return num;
        } else if (c == CHARS[2]) {
            num = 12;
            return num;
        } else if (c == CHARS[3]) {
            num = 13;
            return num;
        }else if (c == CHARS[4]) {
            num = 14;
            return num;
        }else if (c == CHARS[5]) {
            num = 15;
            return num;
        }
        return 0;
    }
}
