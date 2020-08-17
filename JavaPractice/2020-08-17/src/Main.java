import java.util.Arrays;
import java.util.Scanner;

/**
 * 查找兄弟单词
 *
 * @author haozhang
 * @date 2020/08/17
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = sc.next();
            }

            String base = sc.next();
            int index = sc.nextInt();

            String[] ret = new String[n];
            int count = 0;

            for (int i = 0; i < str.length; i++) {
                if (isBrotherWords(str[i], base)) {
                    if (notEquals(str[i], base)) {
                        ret[count++] = str[i];
                    }
                }
            }

            if (count == 0) {
                System.out.println(count);
            } else if (count > 0){
                System.out.println(count);
                if (count >= index) {
                    String[] arr = Arrays.copyOfRange(ret, 0, count);
                    Arrays.sort(arr);
                    System.out.println(arr[index - 1]);
                }
            }

        }
    }

    private static boolean isBrotherWords(String word, String base) {
        if (word.length() != base.length()) {
            return false;
        }

        char[] arr1 = word.toCharArray();
        char[] arr2 = base.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    private static boolean notEquals(String word, String base) {
        char[] arr1 = word.toCharArray();
        char[] arr2 = base.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return true;
            }
        }
        return false;
    }
}
