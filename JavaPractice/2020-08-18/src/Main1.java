import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1、构成单词的字符只有26个大写或小写英文字母；
 *
 * 2、非构成单词的字符均视为单词间隔符；
 *
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒
 * 排转换后也只允许出现一个空格间隔符；
 *
 * 4、每个单词最长20个字母；
 *
 * @author haozhang
 * @date 2020/08/18
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            transition(s);
        }
    }

    public static void transition(String s) {
        if (isAllLetters(s)) {
            String[] str = s.split(" ");
            for (int i = str.length - 1; i >= 0; i--) {
                System.out.print(str[i]);
                if (i > 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        } else {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (isLetter(c)) {
                    for (int j = i + 1; j < s.length(); j++) {
                        if (!isLetter(s.charAt(j))) {
                            list.add(s.substring(i, j));
                            i = j;
                            break;
                        }
                    }
                }
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i));
                if (i > 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isAllLetters(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLetter(c)) {
                continue;
            } else if (c == ' ') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else {
            return false;
        }
    }
}
