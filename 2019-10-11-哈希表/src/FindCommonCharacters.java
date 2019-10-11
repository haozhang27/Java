import java.util.*;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/11
 */
public class FindCommonCharacters {
    public static List<String> commonChars (String[] a) {
        // 统计每个单词中，每个字母出现的次数
       List<Map<Character, Integer>> counts = new ArrayList<>();
       for (String s : a) {
           Map<Character, Integer> map = new HashMap<>(16);
           for (char c : s.toCharArray()) {
               int n = map.getOrDefault(c, 0);
               map.put(c, n + 1);
           }
           counts.add(map);
       }

       List<String> result = new ArrayList<>();

       //从 counts 中找出 abel
       for (char c : counts.get(0).keySet()) {
           boolean allContains = true;
           for (int i = 0; i < counts.size(); i++) {
               Map<Character, Integer> map = counts.get(i);
               if (!map.containsKey(c)) {
                   allContains = false;
                   break;
               }
           }

           if (!allContains) {
               continue;
           }

           //找到 c 在每个单词中出现次数的最小值
           int min = counts.get(0).get(c);
           for (int i = 1; i < counts.size(); i++) {
               int n = counts.get(i).get(c);
               if (n < min) {
                   min = n;
               }
           }

           //c 这个字母，在每个单词中都至少出现了 min 次
           for (int i = 0; i < min; i++) {
               result.add(String.valueOf(c));
           }
       }

       return result;
    }

    public static List<String> commonChars2 (String[] args) {
        List<int[]> counts = new ArrayList<>();
        int size = 26;
        for (String s : args) {
            int[] array = new int[size];
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                array[index]++;
            }
            counts.add(array);
        }

        int[] r = new int[size];
        for (int i = 0; i < r.length; i++) {
            int n = Integer.MAX_VALUE;
            for (int[] a : counts) {
                n = Math.min(n, a[i]);
            }
            r[i] = n;
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < r[i]; j++) {
                char c = (char)('a' + i);
                result.add(String.valueOf(c));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] a = {"bella","label","roller"};
        System.out.println(commonChars(a));

        System.out.println(commonChars2(a));
    }
}
