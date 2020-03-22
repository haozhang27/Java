import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/22
 */
public class Main {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ret = new ArrayList<>();
        int n = str.length();
        if (n == 0) {
            return ret;
        }
        backtrack(ret, str.toCharArray(), 0, n);
        Collections.sort(ret);
        return ret;
    }

    private void backtrack(ArrayList<String> ret, char[] arr, int first, int n) {
        if (first == n) {
            ret.add(new String(arr));
        }

        for (int i = first; i < n; i++) {
            //加这一条是为了去重
            if (i == first || arr[i] != arr[first]) {
                swap(arr, i, first);
                backtrack(ret, arr, first + 1, n);
                swap(arr, i, first);
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public int MoreThanHalfNum_Solution(int [] arr) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val > arr.length / 2) {
                ret = key;
            }
        }
        return ret;
    }
}
