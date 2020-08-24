import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，
 * 选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。
 * 现在，修改过的那个单词属于字母表的下面，如下所示：
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 *
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，
 * 并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，
 * Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
 *
 * @author haozhang
 * @date 2020/08/24
 */
public class Main1 {
    static char[] chars = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String key = sc.nextLine();
            String clearText = sc.nextLine();
            System.out.println(encrypt(key, clearText));
        }
    }

    public static String encrypt(String key, String clearText) {
        StringBuilder sb1 = new StringBuilder();
        Set<Character> set = getSet(key);
        for (char c : set) {
            sb1.append(c);
        }

        StringBuilder sb2 = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        for (int i = 0; i < sb1.length(); i++) {
            char c = sb1.charAt(i);
            for (int j = 0; j < sb2.length(); j++) {
                if (sb2.charAt(j) == c) {
                    sb2.deleteCharAt(j);
                } else if (sb2.charAt(j) == (char)(c + 32)) {
                    sb2.deleteCharAt(j);
                }
            }
        }

        sb1.append(sb2);

        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < clearText.length(); i++) {
            char c = clearText.charAt(i);
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == c) {
                    ret.append(sb1.charAt(j));
                    break;
                } else if (chars[j] == (char)(c + 32)) {
                    char c1 = (char)(sb1.charAt(j) - 32);
                    ret.append(c1);
                    break;
                }
            }
            if (!isLetters(c)) {
                ret.append(c);
            }
        }
        return ret.toString();

    }

    public static boolean isLetters(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else {
            return false;
        }
    }


    public static Set<Character> getSet(String key) {
        key = key.toLowerCase();
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            set.add(c);
        }

        return set;
    }
}
