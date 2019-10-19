import java.util.Arrays;
import java.util.HashSet;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/19
 */
public class Practice1 {
    public String reverseVowels(String s) {
        HashSet<Character> hashSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0;
        int j = s.length() - 1;
        char[] ret = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            if (!hashSet.contains(ci)) {
                ret[i] = ci;
                i++;
            } else if (!hashSet.contains(cj)) {
                ret[j] = cj;
                j--;
            } else {
                ret[i] = cj;
                i++;
                ret[j] = ci;
                j--;
            }
        }
        return new String(ret);
    }
}
