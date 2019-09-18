public class MyLinkedList implements List{
    /**
     * 静态类 ListNode
     * 用这个类来定义链表的结点
     */
    private static class ListNode {
        private ListNode prev;
        private ListNode next;
        private int value;


        private ListNode (int val) {
            this.prev = null;
            this.next = null;
            this.value = val;
        }

        private ListNode (int val, ListNode prev, ListNode next) {
            this(val);
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString () {
            return  "Node{"
                    + "value = " + value
                    + "}";
        }
    }

    /**
     *记录链表的第一个结点
     */
    private ListNode head = null;

    /**
     * 记录链表的最后一个结点
     */
    private ListNode last = null;

    /**
     *记录链表中元素的个数
     */
    private int size = 0;

    /**
     * 进行尾插操作
     * @param element 要插入元素的值
     * @return 返回 true 代表成功，false 代表失败
     */
    @Override
    public boolean add(int element) {
        return add(size, element);
    }

    /**
     * 把 element 插入到 index 处
     * @param index 要插入到的位置
     * @param element 要插入的元素值
     * @return true 代表成功，false 代表失败
     */
    @Override
    public boolean add(int index, int element) {
        //1.判断下标的合法性
        if (index < 0 || index > size) {
            System.out.println("下标不合法");
            return false;
        }

        //2.当 index == 0 时特殊处理
        if (index == 0) {
            head = new ListNode(element, null, head);

            if (head.next != null) {
                head.prev.next = head;
            }

            if (size == 0) {
                last = head;
            }

            size++;
            return true;
        }

        if(index == size) {
            last = new ListNode(element, last, null);
            if (last.prev != null) {
                last.prev.next = last;
            }
            if (size == 0) {
                head = last;
            }

            size++;
            return true;
        }

        //2.找到 index 位置的结点的结点 node
        //如果 index 在左边，从 head 往后找，如果在右边，从last往前找
        ListNode node = getNode(index);

        //3.把 element 装到结点中
        //4.node 前驱的 next = element 所在的结点
        //5.element 所在结点的next = node

        ListNode newNode = new ListNode(element, node.prev, node);
        node.prev.next = newNode;
        node.prev = newNode;

        //6.size++
        return true;
    }

    /**
     * 通过下标访问
     * @param index 要访问的下标
     * @return 返回访问的下标处的值
     */
    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("下标不合法");
            return -1;
        }
        return getNode(index).value;
    }

    /**
     * 修改 index 处的值
     * @param index 要修改的位置的下标
     * @param val 将 index 处的值变为 val
     * @return 修改后的 index 处的值
     */
    @Override
    public int set(int index, int val) {
        if (index < 0 || index >= size) {
            System.out.println("下标不合法");
            return -1;
        }

        ListNode node = getNode(index);
        int oldValue = node.value;
        node.value = val;
        return oldValue;
    }

    /**
     * 删除 index 处的值
     * @param index 要删除位置的下标
     * @return 删除之后 index 位置元素的值
     */
    @Override
    public int remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("下标不合法");
            return -1;
        }

        ListNode node = getNode(index);
        if (node.prev != null){
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            last = node.prev;
        }
        size--;

        return node.value;
    }

    /**
     * 获取链表数据个数
     * @return 数据个数
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 判断链表是否为空
     * @return true 代表为空，false 代表非空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 找到 index 下标所在的结点
     * index 一定是合法的
     * 判断是从后往前找 还是从前往后找
     * @param index [0,size)
     * @return 找到的结点
     */
    private ListNode getNode(int index) {
        if (index < size / 2) {
            ListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        } else {
            ListNode cur = last;
            for (int i = 0; i < size - index - 1; i++) {
                cur = cur.prev;
            }
            return cur;
        }
    }

    /**
     * 遍历链表
     * @return 链表的所有
     */
    @Override
    public String toString () {
        String r = "[";
        for (ListNode cur = head; cur != null; cur = cur.next) {
                r += (cur.value + ",");
        }
        r += "]";
        return r;
    }
}

