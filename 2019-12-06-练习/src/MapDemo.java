import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/06
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(16);
        map.put(1, "hello");
        map.put(2, "java");

        System.out.println(map);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(22));


        for (Integer i : map.keySet()) {
            System.out.println(i);
        }

        for (String value : map.values()) {
            System.out.println(value);
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
