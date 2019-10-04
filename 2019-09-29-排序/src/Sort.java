/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/29
 */
public class Sort {

    public static void quickSort (int[] array) {
        quickSortInternal(array, 0, array.length);
    }

    private static void quickSortInternal(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        //确定基准值：array[right] 作为基准值
        //遍历 小的左，大的右
        int pivotIndex = partition1(array, left, right);
        //分出的两个小区间
        //[left, pivotIndex - 1]
        //[pivotIndex + 1, right]
        quickSortInternal(array, left, pivotIndex - 1);
        quickSortInternal(array, pivotIndex, right);
    }

    private static int partition1(int[] array, int left, int right) {
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
        }

        swap(array, less, great);
        return less;
    }

    private static int partition2(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        int great = right;

        while (less < great) {
            while (less < great && array[less] <= pivot) {
                less++;
            }
            array[great] = array[less];

            while (less < great && array[great] >= pivot) {
                great--;
            }
        }
        array[great] = pivot;
        return less;
    }

    private static int partition3(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        //[left, less) < pivot
        //[less, i) >= pivot
        //[i, right)
        for (int i = left; i < right; i++) {
           if (array[i] < pivot) {
               swap(array, less, i);
               less++;
           }
        }

        swap(array, left, right);
        return less;
    }



    private static void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
    }
}
