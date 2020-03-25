import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Main {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
     * @param numbers
     * @return
     */
    public String printMinNumber(int [] numbers) {
        StringBuilder sb = new StringBuilder();
        String str1 = null;
        String str2 = null;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                str1 = String.valueOf(numbers[j]);
                str2 = String.valueOf(numbers[j + 1]);
                if ((str1 + str2).compareTo(str2 + str1) > 0) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
     * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
     * @param str
     * @return
     */
    public int firstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int n = map.getOrDefault(c, 0);
            map.put(c, n + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            int val = map.get(str.charAt(i));
            if (val == 1) {
                return i;
            }
        }

        return -1;
    }
}
