import java.util.*;
/**
 * 认识 Map
 *
 * @author haozhang
 * @date 2019/09/10
 */
public class Demo2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("作者"));
        System.out.println(map.getOrDefault("作者", "佚名"));
        System.out.println(map.containsKey("作者"));
        System.out.println(map.containsValue("佚名"));

        map.put("作者", "鲁迅");
        map.put("标题", "狂人日记");

        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("作者"));
        System.out.println(map.getOrDefault("作者", "佚名"));
        System.out.println(map.containsValue("佚名"));

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
