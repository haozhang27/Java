import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/23
 */
public class Main {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (input.length < k || k == 0) {
            return ret;
        }
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int baseIndex = pratition(arr, left, right);
        quickSort(arr, left, baseIndex - 1);
        quickSort(arr, baseIndex + 1, right);
    }

    private int pratition(int[] arr, int left, int right) {
        int base = arr[right];
        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && arr[i] <= base) {
                i++;
            }
            swap(arr, i, j);

            while (i < j && arr[j] >= base) {
                j--;
            }
            swap(arr, i, j);
        }

        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int findGreatestSumOfSubArray(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int ret = 0;
            for (int j = i; j < arr.length; j++) {
                ret += arr[j];
                list.add(ret);
            }
        }

        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
