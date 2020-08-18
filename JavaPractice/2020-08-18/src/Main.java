import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 将输入的两个字符串合并。
 *
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。
 * 这里的下标意思是字符在字符串中的位置。
 *
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，
 * 则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，
 * 则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，
 * 也就是e。转换后的字符为大写‘E’。
 *
 * @author haozhang
 * @date 2020/08/18
 */
public class Main {
    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put('a', '5'); map.put('A', '5');
        map.put('b', 'D'); map.put('B', 'D');
        map.put('c', '3'); map.put('C', '3');
        map.put('d', 'B'); map.put('D', 'B');
        map.put('e', '7'); map.put('E', '7');
        map.put('f', 'F'); map.put('F', 'F');
        map.put('0', '0'); map.put('1', '8');
        map.put('2', '4'); map.put('3', 'C');
        map.put('4', '2'); map.put('5', 'A');
        map.put('6', '6'); map.put('7', 'E');
        map.put('8', '1'); map.put('9', '9');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    sb.deleteCharAt(i);
                }
            }
            System.out.println(getStr(sb.toString()));
        }
    }

    public static String getStr(String str) {
        String s = getMergeStr(str);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isHex(c)) {
                sb.append(map.get(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String getMergeStr(String s) {
        int i1 = 0, i2 = 0;
        char[] arr1 = new char[s.length() / 2 + 1];
        char[] arr2 = new char[s.length() / 2 + 1];
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                arr1[i1++] = s.charAt(i);
            } else {
                arr2[i2++] = s.charAt(i);
            }
        }

        char[] new1 = Arrays.copyOfRange(arr1, 0, i1);
        char[] new2 = Arrays.copyOfRange(arr2, 0, i2);
        Arrays.sort(new1);
        Arrays.sort(new2);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < new1.length || j < new2.length) {
            if (i < new1.length) {
                sb.append(new1[i]);
                i++;
            }
            if (j < new2.length) {
                sb.append(new2[j]);
                j++;
            }
        }
        return sb.toString();
    }

    public static boolean isHex(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else if (c >= 'A' && c <= 'F') {
            return true;
        } else if (c >= 'a' && c <= 'f') {
            return true;
        } else {
            return false;
        }
    }
}
