import java.util.Scanner;

/**
 * 1、对输入的字符串进行加解密，并输出。
 *
 * 2加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 3、解密方法为加密的逆过程。
 *
 * @author haozhang
 * @date 2020/08/17
 */
public class Main1 {
    private static char[] CAPITAL_LETTER = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static char[] SMALL_LETTER = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static char[] NUMBERS = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            char[] arr1 = sc.nextLine().toCharArray();
            char[] arr2 = sc.nextLine().toCharArray();
            encrypt(arr1);
            unEncrypt(arr2);
        }
    }

    public static void encrypt (char[] aucPassword) {
        char[] aucResult = new char[aucPassword.length];
        for (int i = 0; i < aucPassword.length; i++) {
            char c = aucPassword[i];
            if (isLetter(c) && isCapitalLetter(c)) {
                int index = Math.floorMod(indexOfCapitalLetter(c) + 1, 26);
                aucResult[i] = SMALL_LETTER[index];
            } else if (isLetter(c) && !isCapitalLetter(c)) {
                int index = Math.floorMod(indexOfSmallLetter(c) + 1, 26);
                aucResult[i] = CAPITAL_LETTER[index];
            } else if (isNumber(c)) {
                int index = Math.floorMod(indexOfNumber(c) + 1, 10);
                aucResult[i] = NUMBERS[index];
            } else {
                aucResult[i] = aucPassword[i];
            }
        }
        System.out.println(String.valueOf(aucResult));
    }

    private static boolean isLetter(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }

        if (c >= 'a' && c <= 'z') {
            return true;
        }

        return false;
    }

    private static boolean isCapitalLetter(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    private static int indexOfCapitalLetter(char c) {
        for (int i = 0; i < CAPITAL_LETTER.length; i++) {
            if (CAPITAL_LETTER[i] == c) {
                return i;
            }
        }
        return 0;
    }

    private static int indexOfSmallLetter(char c) {
        for (int i = 0; i < SMALL_LETTER.length; i++) {
            if (SMALL_LETTER[i] == c) {
                return i;
            }
        }
        return 0;
    }

    private static boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    private static int indexOfNumber(char c) {
        for (int i = 0; i < NUMBERS.length; i++) {
            if (c == NUMBERS[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void unEncrypt (char[] result) {
        char[] password = new char[result.length];
        for (int i = 0; i < result.length; i++) {
            char c = result[i];
            if (isLetter(c) && isCapitalLetter(c)) {
                int index = Math.floorMod(indexOfCapitalLetter(c) - 1, 26);
                password[i] = SMALL_LETTER[index];
            } else if (isLetter(c) && !isCapitalLetter(c)) {
                int index = Math.floorMod(indexOfSmallLetter(c) - 1, 26);
                password[i] = CAPITAL_LETTER[index];
            } else if (isNumber(c)) {
                int index = Math.floorMod(indexOfNumber(c) - 1, 10);
                password[i] = NUMBERS[index];
            } else {
                password[i] = result[i];
            }
        }
        System.out.println(String.valueOf(password));
    }
}
