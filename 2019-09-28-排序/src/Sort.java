import java.util.Random;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/28
 */
public class Sort {
    /**
     * 插入排序
     * 有序区间 [0,i]；无序区间 [i + 1, array.length)
     * 待插入数据是 array[i + 1]
     * 插入过程在有序区间查找
     *
     * @param array 待排序数组
     */
    public static void insertSort1 (int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int key = array[i + 1];
            int j;
            for (j = i; j >= 0 && key < array[i]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }

    }

    public static void insertSort2 (int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int key = array[i + 1];
            int j;
            for (j = i; j >= 0; j--) {
                if (key >= array[j]) {
                    array[j + 1] = key;
                    break;
                }
            }

            // j + 1 的位置 放 key
            for (int k = i; k > j; k--) {
                array[k + 1] = array[k];
            }
        }
    }

    /**
     * 希尔排序
     * @param array 要排序的数组
     * @param gap
     */
    private static void insertSortWithGap (int[] array, int gap) {
        for (int i = 0; i < array.length - gap; i++) {
            int key = array[i + gap];
            int j;
            for (j = i; j >= 0 && key < array[j]; j -= gap) {
                array[j + gap] = array[j];
            }

            array[j + gap] = key;
        }
    }

    public static void shellSort(int[] array) {
        int gap = array.length;
        while (true) {
            gap = gap/3 + 1;
            insertSortWithGap(array, gap);
            if (gap == 1) {
                return;
            }
        }
    }

    /**
     * 直接选择排序
     * 每次选最大的数和无序区间的最后一个数交换
     * 无序区间 [0，array.length - i)
     * 有序区间 [array.length - i, array.length]
     * @param array 要排序的数组
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int indexOfMax = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] >= array[indexOfMax]) {
                    indexOfMax = j;
                }
            }

            swap(array, indexOfMax, array.length - i - 1);
        }
    }

    public static void selectSortVersion2(int[] array) {

    }

    /**
     * 堆排序
     * 利用堆的性质，把数组创建成堆，然后每次选出最大的数，放到有序区间
     * 无序区间长度 array.length - i - 1
     * @param array 要排序的数组
     */
    public static void headSort(int[] array) {
        createHeap(array, array.length);
        for (int i = 0; i < array.length - 1; i++) {
            // 无序区间 [0, array.length - i)
            swap(array, 0, array.length - i - 1);
            // 无序区间 [0, array.length - i - 1)
            heapify(array, array.length - i - 1, 0);
        }
    }

    private static void heapify(int[] array, int length, int index) {
        while (true) {
            int left = 2 * index + 1;
            if (left >= length) {
                return;
            }

            int max = left;
            if (left + 1 < length) {
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

    private static void createHeap(int[] array, int length) {
        for (int i = (length - 2) / 2; i >= 0; i--) {
            heapify(array, length, i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void  heapSort(int[] array) {

    }

    private static int[] buildSortedArray (int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int[] buildReversedSortedArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = n - i;
        }
        return array;
    }

    private static int[] buildRandomArray(int n) {
        Random random = new Random(20190828);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }

        return array;
    }

    private static int[] buildEqualsArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = n;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array;

        array = buildSortedArray(10);
        long begin = System.nanoTime();
        insertSort1(array);
        long end = System.nanoTime();
        System.out.println(end - begin);

    }
}
