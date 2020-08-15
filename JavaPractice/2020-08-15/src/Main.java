import java.util.*;

/**
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
 * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * @author haozhang
 * @date 2020/08/15
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(getStr(s));
        }
    }

    public static String getStr(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = map.getOrDefault(c, 0);
            map.put(c, n + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val == getKeyVal(map)) {
                sb.append(key);
            }
        }

        StringBuilder sb1 = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char key = sb.charAt(i);
            for (int j = 0; j < sb1.length(); j++) {
                if (key == sb1.charAt(j)) {
                    sb1.deleteCharAt(j);
                }
            }
        }

        return sb1.toString();

    }


    public static int getKeyVal(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2)
            {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return compare;
            }
        });

        return list.get(0).getValue();
    }
}
