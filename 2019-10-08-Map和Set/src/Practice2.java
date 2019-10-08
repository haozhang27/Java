
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/08
 */
public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();
        String actual = scanner.nextLine();

        Set<Character> set = new HashSet<>();
        char[] array1 = actual.toUpperCase().toCharArray();
        for (char c : array1) {
            set.add(c);
        }

        Set<Character> brokenKeys = new HashSet<>();
        char[] array2 = expected.toUpperCase().toCharArray();
        for (char c : array2) {
            if (!set.contains(c)) {
                if (!brokenKeys.contains(c)) {
                    System.out.print(c);
                    brokenKeys.add(c);
                }
            }
        }
    }
}
