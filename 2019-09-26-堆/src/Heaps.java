import java.util.Arrays;

/**
 * 对堆的认识及练习
 *
 * @author haozhang
 * @date 2019/09/26
 */
public class Heaps {
    //public static adjustDown

    /**
     * 前提：除了 index 和它的孩子外，其他位置已经满足堆的性质了
     *
     * 经过向下调整，最终完成一个堆
     * 时间复杂度 O(log(n))
     *
     * @param array 被看作堆的数组
     * @param size 数组中被看作堆值的个数
     * @param index 要调整位置的下标
     */
    public static void heapify(int[] array, int size, int index) {
        while (true) {
            int left = 2 * index + 1;
            if (left >= size) {
                return;
            }

            int max = left;
            if (left + 1 < size) {
                if (array[left + 1] > array[left]) {
                    max = left + 1;
                }
            }

            if (array[index] >= array[max]) {
                return;
            }

            swap(array, index, max);

            index = max;
        }
    }

    /**
     * 交换数组的 array[i] 和 array[j] 位置
     * @param array 要交换的数组
     * @param i 要交换的位置
     * @param j 要交换的位置
     */
    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /**
     * 将任意数组调整为堆
     *
     * 时间复杂度 O(n)
     *
     * @param array 要调整的数组
     * @param size 数组的长度
     */
    public static void createHeap(int[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(array, size, i);
        }
    }

    /**
     * 向上调整
     * @param array 要调整的数组
     * @param index 调整的位置
     */
    public static void adjustUp(int[] array, int index) {
        while (true) {
            if (index == 0) {
                return;
            }
            if (array[index] <= array[(index - 1) / 2]) {
                return;
            }
            swap(array, index, (index - 1) / 2);

            index = (index - 1) / 2;
        }
    }

    public static void  heapifyMin(int[] array, int size, int index) {
        while (true) {
            int left = 2 * index + 1;
            if (left >= size) {
                return;
            }

            int min = left;
            if (left + 1 < size) {
                if (array[left + 1] < array[left]) {
                    min = left + 1;
                }
            }

            if (array[index] <= array[min]) {
                return;
            }

            swap(array, index, min);
            index = min;
        }
    }
    public static void main(String[] args) {
        int[] array = new int[] {-1, 8, 4, 6, 7, 2, 3, 1, 0};
        heapify(array, array.length, 0);
        System.out.println(Arrays.toString(array));

        heapify(array, array.length, 0);
        System.out.println(Arrays.toString(array));

        int[] array1 = {3, 5, 2, 4, 9, 0, 1, 9, 8, 4, 7, 2, 3, 8, 6, 3};
        createHeap(array1, array1.length);
        System.out.println(Arrays.toString(array1));

    }
}
