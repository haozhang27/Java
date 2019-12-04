/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/04
 */
public class Practice2 {
    /**
     * 堆排序
     * 利用堆的性质，把数组创建成堆，然后每次选出最大的数，放到有序区间
     * 无序区间长度 array.length - i - 1
     * @param array 要排序的数组
     */
    public void headSort(int[] array) {
        createHeap(array, array.length);
        for (int i = 0; i < array.length - 1; i++) {
            // 无序区间 [0, array.length - i)
            swap(array, 0, array.length - i - 1);
            // 无序区间 [0, array.length - i - 1)
            heapify(array, array.length - i - 1, 0);
        }
    }

    private void heapify(int[] array, int length, int index) {
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

    private void swap(int[] array, int index, int max) {
        int tmp = array[index];
        array[index] = array[max];
        array[max] = tmp;
    }

    private void createHeap(int[] array, int length) {
        for (int i = (length - 2) / 2; i >= 0; i--) {
            heapify(array, length, i);
        }
    }
}
