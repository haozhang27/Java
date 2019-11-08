import java.util.*;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/08
 */
public class Practice2 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。
     * 字母异位词指字母相同，但排列不同的字符串
     * @param str 给定的数组
     * @return 字母异位词数组
     */
    public List<List<String>> groupAnargms(String[] str) {
        Map<String, List<String>> map = new HashMap<>(16);
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String key = String.valueOf(arr);

            if (map.containsKey(key)) {
                map.get(key).add(str[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str[i]);
                map.put(key, temp);
            }
        }

        return new ArrayList<>(map.values());
    }
}
