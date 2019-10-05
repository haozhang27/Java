import java.util.Arrays;
import java.util.Stack;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/30
 */
public class Sort {
    public static void quickSortNoRecursion(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);

        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                continue;
            }

            int pivotIndex = partition(array, left, right);
            // [left, pivotIndex - 1]
            // [pivotIndex + 1, right]
            stack.push(right);
            stack.push(pivotIndex + 1);

            stack.push(pivotIndex - 1);
            stack.push(left);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        int great = right;

        while (less < great) {
            while (less < great && array[less] <= pivot) {
                less++;
            }

            while (less < great && array[great] >= pivot) {
                great--;
            }
            swap(array, less, great);
        }

        swap(array, right, less);
        return less;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length);
    }
    private static void mergeSortInternal(int[] array, int low, int high) {
        if (low + 1 >= high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int length = high - low;
        int[] extra = new int[length];

        int iLeft = low;
        int iRight = mid;
        int iExtra = 0;

        while (iLeft < mid && iRight < high) {
            if (array[iLeft] <= array[iRight]) {
                extra[iExtra] = array[iLeft];
                iExtra++;
                iLeft++;
            } else {
                extra[iExtra] = array[iRight];
                iExtra++;
                iRight++;
            }
        }

        while (iLeft < mid) {
            extra[iExtra] = array[iLeft];
            iExtra++;
            iLeft++;
        }

        while (iRight < high) {
            extra[iExtra] = array[iRight];
            iExtra++;
            iRight++;
        }

        for (int i = 0; i < length; i++) {
            array[low + i] = extra[i];
        }
    }


    public static void mergeSortNoRecursion(int[] array) {
        for (int i = 1; i < array.length; i = i*2) {
            for (int j = 0; j < array.length; j = j + 2*i) {
                int low = j;
                System.out.println(i);
                System.out.println(j);
                int mid = j + i;
                int high = mid + i;
                if (mid >= array.length) {
                    continue;
                }
                if (high > array.length) {
                    high = array.length;
                }

                merge(array, low, mid, high);
            }
        }
    }



    public static void main(String[] args) {
        int[] array = new int[] {9, 5, 2, 7, 3, 6, 4, 8};

        /*
        quickSortNoRecursion(array);
        System.out.println(Arrays.toString(array));

        mergeSort(array);
        System.out.println(Arrays.toString(array));
         */



        mergeSortNoRecursion(array);
        System.out.println(Arrays.toString(array));


    }
}
