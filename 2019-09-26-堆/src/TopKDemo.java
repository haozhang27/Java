import java.util.Arrays;
import java.util.Random;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/26
 */
public class TopKDemo {
    private static int[] findTopK(int[] array, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = array[i];
        }

        Heaps.createHeap(heap, heap.length);
        for (int i = k; i < array.length; i++) {
            if (array[i] > heap[0]) {
                heap[0] = array[i];
                Heaps.heapifyMin(heap, k, 0);
            }
        }
        return heap;
    }
    public static void main(String[] args) {
        int[] array2 = new int[100];
        Random random = new Random(114158);
        for (int i = 0; i < array2.length; i++) {
            array2[i] = random.nextInt(1000);
        }

        int[] topK = findTopK(array2, 5);
        System.out.println(Arrays.toString(topK));
        System.out.println("================");

        Arrays.sort(array2);

        System.out.println(Arrays.toString(Arrays.copyOfRange(array2,
                array2.length - 10, array2.length)));
    }
}
