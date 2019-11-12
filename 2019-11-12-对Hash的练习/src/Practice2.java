import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/12
 */
public class Practice2 {
    /**
     * 两个字符串中只出现一次的单词
     * @param A 字符串 A
     * @param B 字符串 B
     * @return 只出现一次的单词
     */
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>(16);
        for (String word : A.split(" ")) {
                int n = map.getOrDefault(word, 0);
                map.put(word, n + 1);
            }

        for (String word : B.split(" ")) {
                int n = map.getOrDefault(word, 0);
                map.put(word, n + 1);
            }

        int count = 0;
        String[] ret = new String[A.length() + B.length()];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (val == 1) {
                ret[count] = key;
                count++;
            }
        }
        return Arrays.copyOfRange(ret, 0, count);
    }
}
