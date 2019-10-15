import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/15
 */
public class Practice {
    /**
     * 将字符串的空格部分用 "😊" 替换
     * @param str 要被替换的字符串
     * @return 替换后的字符串
     */
    public static String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("😊");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 输入两行字符串，在输入的第一行中找到输入的第二行中的所有字符，并且删除
     */
    public static void deleteChars() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String pattern = '[' + s2 + ']';
            String ret = s1.replaceAll(pattern, "");
            System.out.println(ret);
        }
    }


    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Welcome to java");
        System.out.println(replaceSpace(str));

        deleteChars();
    }
}