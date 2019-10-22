import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/22
 */
public class Practice1 {
    public boolean checkRecord(String s) {
        Map<Character, Integer> map = new HashMap<>(16);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = map.getOrDefault(c, 0);
            map.put(c, n + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (key == 'A' && value > 1) {
                return false;
            }

            if (key == 'L' && value > 2) {
                return isEqual(s);
            }

        }
        return true;
    }

    private boolean isEqual(String s) {
        for (int i = 0; i < s.length() - 2; i++) {
            char c1 = s.charAt(i);
            if (c1 == 'L' && s.charAt(i + 1) == 'L') {
                if (s.charAt(i + 2) == 'L') {
                    return false;
                }
            }
        }
        return true;
    }
}
