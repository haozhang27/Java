/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/12
 */
public class Practice2 {
    public int findKth(int[] arr, int n, int k) {
        return find(arr, 0, n - 1, k);
    }

    private int find(int[] arr, int low, int high, int k) {
        int part = partation(arr, low, high);

        if (k == part - low + 1) {
            return arr[part];
        }
        
        if (k > part - low + 1) {
            return find(arr, part + 1, high, k - part + low - 1);
        }

        return find(arr, low, part - 1, k);
    }

    private int partation(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (low < high && arr[high] <= key) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[high] >= key) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = key;
        return low;
    }
}
