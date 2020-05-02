import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/05/02
 */
public class Main {
    /**
     * 判断s2是否为s1的子串
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkReverseEqual(String s1, String s2) {
        // write code here
        Map<Character, Integer> map1 = getMap(s1);
        Map<Character, Integer> map2 = getMap(s2);
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (!map2.containsKey(key)) {
                return false;
            } else if (map2.containsKey(key)) {
                if (val != map2.get(key)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 获取s的map
     * @param s
     * @return
     */
    public Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = map.getOrDefault(c, 0);
            map.put(c, n + 1);
        }
        return map;
    }

    public static int[][] clearZero(int[][] mat, int n) {
        // write code here
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ret.add(list);
                }
            }
        }
        System.out.println(ret);

        for (int i = 0; i < ret.size(); i++) {
            int row = ret.get(i).get(0);
            int col = ret.get(i).get(1);
            for (int j = 0; j < n; j++) {
                mat[row][j] = 0;
                mat[j][col] = 0;
            }
        }
        return mat;
    }
}
