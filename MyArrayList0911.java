import java.util.Arrays;

public class MyArrayList0911 implements List {

    /**懒加载的模型
     *1.好处：节省空间，用的时候再申请
     *2.坏处：第一用到时，耗时比平时更大
     */
    int[] array = null;
    int size = 0;

    /**
     * 确保数组长度是否够用
     */
    private void ensureCapacity() {
        //1.如果容量够用，直接返回
        if (array != null && size < array.length) {
            return;
        }

        //2.计算新的容量大小
        int capacity;
        if(array == null) {
            capacity = 10;
        } else {
            capacity = 2 * array.length;
        }

        //3.申请新空间-搬家-朋友圈
        if (array != null) {
            array = Arrays.copyOf(array, capacity);
        } else {
            array = new int[capacity];
        }
    }

    /**
     * 顺序表的尾插
     * @param element 插入的元素的值
     * @return true 表示插入成功，false表示插入失败
     */
    @Override
    public boolean add(int element) {
        return add(size, element);
    }

    /**
     * 将 element 插入到 index 处
     * @param index 要插入的位置
     * @param element 要插入的值
     * @return true 表示插入成功， false 表示插入失败
     */
    @Override
    public boolean add(int index, int element) {
        //1.检查下标
        if (index < 0 || index > size) {
            System.out.println("下标错误");
            return false;
        }

        //2.确保空间够用
        ensureCapacity();

        //3.为 index 下标，腾出位置来
        System.arraycopy(array, index, array, index + 1,
                size - index);

        //4.插入
        array[index] = element;

        /**
         *for (int i = size - 1; i >= index; i--) {
         *   array[i + 1] = array[i];
         *}
         *array[index] = element;
         */

        //5.变更长度
        size++;

        return true;
    }

    /**
     * 获取 index 处的元素
     * @param index 要访问的位置的下标
     * @return index处的值
     */
    @Override
    public int get(int index) {
        //1.判断下表合法性
        if (index < 0 || index >= size) {
            System.out.println("下标错误");
            return -1;
        }
        return array[index];
    }

    /**
     * 修改 index 处的值
     * @param index 要修改的位置
     * @param val 将 index 处的值修改为 val
     * @return 修改后 index 处的值
     */
    @Override
    public int set(int index, int val) {
        //1.判断下标合法性
        if (index < 0 || index >= size) {
            System.out.println("下标错误");
            return -1;
        }

        int oldVal = array[index];
        array[index] = val;
        return oldVal;
    }

    /**
     * 删除 index 处的值
     * @param index 要删除的位置
     * @return 删除后 index 位置的值
     */
    @Override
    public int remove(int index) {
        //1.判断下标合法性
        if (index < 0 || index >= size) {
            System.out.println("下标错误");
            return -1;
        }

        int oldValue = array[index];
        System.arraycopy(array, index + 1, array, index,
                size - index - 1);

        /**
         *for (int i = index; i < size; i++) {
         *    array[i] = array[i + 1];
         *}
         *size--;
         *return index;
         */

        size--;
        return oldValue;
    }

    /**
     * 获取顺序表中数据的个数
     * @return 数据个数
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 判断顺序表是否为空
     * @return true 表示为真， false 表示为假
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 打印顺序表
     * @return 打印的顺序表
     */
    @Override
    public String toString () {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

}
