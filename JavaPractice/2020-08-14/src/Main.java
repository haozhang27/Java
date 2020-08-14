import java.util.Scanner;

/**
 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6,
 * pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，
 * 数字和其他的符号都不做变换，
 *
 *
 *
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移
 * 一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
 *
 * @author haozhang
 * @date 2020/08/14
 */
public class Main {
    static char[] chars = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static int[] nums = new int[] {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7,
            8, 8, 8, 9, 9, 9, 9};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(getCiphertext(s));
        }
    }

    public static String getCiphertext(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLowercase(c)) {
                sb.append(nums[getIndex(c, true)]);
            } else if (isCapitalLetter(c)) {
                sb.append(chars[getIndex(c, false) % 26]);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static int getIndex(char c, boolean flag) {
        for (int i = 0; i < chars.length; i++) {
            if (flag && c == chars[i]) {
                return i;
            } else if (!flag && c + 32 == chars[i]){
                return i + 1;
            }
        }
        return 0;
    }



    public static boolean isLowercase(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }

    public static boolean isCapitalLetter(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
}
