import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/12
 */
public class Practice1 {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>(16);
        int ret = 0;
        for (int i = 0; i < chars.length(); i++) {
            int n = map.getOrDefault(chars.charAt(i), 0);
            map.put(chars.charAt(i), n + 1);
        }

        for (String word : words) {
            if (isContain(map, word)) {
                ret += word.length();
            }
        }
        return ret;
    }

    private boolean isContain(Map<Character, Integer> map, String word) {
        Map<Character, Integer> mapWord = new HashMap<>(16);
        for (char c : word.toCharArray()) {
            int n = mapWord.getOrDefault(c, 0);
            mapWord.put(c, n + 1);
        }

        for (char c : mapWord.keySet()) {
            if (mapWord.get(c) > map.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }
}
