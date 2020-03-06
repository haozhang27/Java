import java.util.Stack;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/06
 */
public class Main {
    private static Stack<Integer> STACK_ONE = new Stack<Integer>();
    private static Stack<Integer> STACK_TWO = new Stack<Integer>();

    public static void push(int node) {
        STACK_ONE.push(node);
    }

    public int pop() {
        while(!STACK_ONE.isEmpty()) {
            int val = STACK_ONE.pop();
            STACK_TWO.push(val);
        }

        int ret = STACK_TWO.pop();
        while(!STACK_TWO.isEmpty()) {
            int val = STACK_TWO.pop();
            STACK_ONE.push(val);
        }

        return ret;
    }

    public static int minNumberInRotateArray(int [] array) {
        quickSort(array, 0, array.length - 1);
        return array[0];
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int baseIndex = partition(arr, left, right);
        quickSort(arr, left, baseIndex - 1);
        quickSort(arr, baseIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int base = arr[right];

        while(i < j) {
            while(i < j && arr[i] <= base) {
                i++;
            }
            swap(arr, i, j);

            while(i < j && arr[j] >= base) {
                j--;
            }
            swap(arr, i, j);
        }
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        System.out.println(minNumberInRotateArray(arr));
    }
}
