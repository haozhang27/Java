import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/20
 */
public class Practice2 {
    /**
     * 给定一个 k 位整数，输出所具有的元素以及对应个数，元素要按照升序输出
     */
    public void mapKeyValue() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = map.getOrDefault(c, 0);
            map.put(c, num + 1);
        }

        char[] arr = new char[map.size()];
        int k = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            arr[k] = key;
            k++;
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + ":" + map.get(arr[i]));
        }
    }
}
