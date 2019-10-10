import java.util.*;
public class Practice {
    public static Map<String, Integer> count (String[] array) {
        Map<String, Integer> map = new HashMap<>(16);
        for (String s : array) {
            int c = map.getOrDefault(s, 0);
            map.put(s, c + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String[] array = {"i", "l", "o", "v", "e", "j", "a", "v", "a"};
        System.out.println(count(array));
    }
}
