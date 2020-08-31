import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 找出字符串中第一个只出现一次的字符
 *
 * @author haozhang
 * @date 2020/08/31
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(getFirst(s));
        }
    }

    public static String getFirst(String s) {
        Map<String, Integer> map = new LinkedHashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            int n = map.getOrDefault(c, 0);
            map.put(c, n + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (val == 1) {
                return key;
            }
        }

        return "-1";
    }
}
