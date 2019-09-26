/**
 * 实现堆
 *
 * @author haozhang
 * @date 2019/09/26
 */
public class MyPriorityQueue {
    /**
     * 先不考虑 array 放不下的情况
     */
    private int[] array = new int[100];
    private int size = 0;

    public void add(int element) {
        array[size] = element;
        size++;
        Heaps.adjustUp(array, size - 1);
    }

    /**
     * 时间复杂度 log(n)
     * @return 堆顶元素
     */
    public int poll() {
        int e = array[0];
        --size;
        array[0] = array[size];
        Heaps.heapify(array, size, 0);
        return e;
    }

    public int peek() {
        return array[0];
    }
    public static void main(String[] args) {
    }
}
