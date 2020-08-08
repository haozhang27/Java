import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * @author haozhang
 * @date 2020/08/08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(getLastWord(s).length());
        }
    }

    public static String getLastWord(String s) {
        String[] strings = s.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            String str = strings[i];
            if (isWord(str)) {
                return str;
            }
        }
        return null;
    }

    public static boolean isWord(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else {
            return false;
        }
    }
}
