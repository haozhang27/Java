import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/08
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(16);
        map.put(1, "hello");
        map.put(1, "Hello");
        map.put(2, "java");
        map.put(3, "SE");
        map.put(7, "SE");

        System.out.println(map);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(4));
        System.out.println(map.getOrDefault(4, "默认值"));
        System.out.println(map);


        for (Integer i : map.keySet()) {
            System.out.println(i);
        }

        for (String value : map.values()) {
            System.out.println(value);
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
