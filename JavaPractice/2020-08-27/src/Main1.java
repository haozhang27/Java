import java.util.*;

/**
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 *
 * @author haozhang
 * @date 2020/08/27
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                System.out.println(getMax(s));
            }
        }
    }

    public static int getMax(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = map.getOrDefault(c, 0);
            map.put(c, n + 1);
        }

        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int num = 0;
        int len = 26;
        for (Map.Entry<Character, Integer> entry : list) {
            num += entry.getValue() * len;
            len--;
        }
        return num;
    }
}
