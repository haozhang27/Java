public interface List0911 {
    /**
     * 尾插
     * @param element 要插入的值
     * @return true 表示插入成功， false 表示失败
     */
    boolean add(int element);

    /**
     * 将 element 插入到 index
     * @param index 要插入的位置
     * @param element 要插入的值
     * @return true 表示插入成功， false 表示失败
     */
    boolean add(int index, int element);

    /**
     * 访问 index 处的元素
     * @param index 要访问的位置
     * @return index 处的值
     */
    int get(int index);

    /**
     * jiang index 处的值修改为 val
     * @param index 要修改的位置
     * @param val 将 index 处的值修改为 val
     * @return 修改后 index处的值
     */
    int set(int index, int val);

    /**
     * 删除 index 处的元素
     * @param index 要删除的位置
     * @return 删除后 index 处的值
     */
    int remove(int index);

    /**
     * 获取线性表元素的个数
     * @return 线性表元素的个数
     */
    int size();

    /**
     * 判断线性表是否为空
     * @return true 表示为空， false 表示非空
     */
    boolean isEmpty();
}


