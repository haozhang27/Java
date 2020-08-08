import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母和数字组成的字符串，
 * 和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * @author haozhang
 * @date 2020/08/08
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String strc = sc.nextLine();
            System.out.println(getCount(str, strc));
        }
    }

    public static int getCount(String str, String strc) {
        char[] chars = str.toUpperCase().toCharArray();
        char c = strc.toUpperCase().charAt(0);
        int ret = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                ret++;
            }
        }
        return ret;
    }
}
