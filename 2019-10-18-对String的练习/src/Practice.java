import java.util.HashMap;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/18
 */
public class Practice {
    public int fristUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = hashMap.getOrDefault(c, 0);
            hashMap.put(c, n + 1);
        }


        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
