
class ListNode {
    public ListNode next;
    public int value;

    public ListNode (int val) {
        this.next = null;
        this.value = val;
    }
}

/**
 * 对链表的练习
 *
 * @author haozhang
 * @date 2019/09/05
 */
public class Practice0905 {
    /**
     * 创建链表
     * @return 创建的链表的头节点
     */
    private static ListNode creatLinkedList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        return n1;
    }

    /**
     * 遍历链表
     * @param head 链表的头节点
     */
    private static void displayLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.printf("(%d) --> ", cur.value);
            cur = cur.next;
        }
        System.out.println("null");
    }

    /**
     * 链表的头插
     * @param head 原链表的头结点
     * @param val 要插入的结点值
     * @return 完成头插操作之后 链表的头节点
     */
    private static ListNode pushFront(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        newNode.next = head;

        //改变形参没有意义
        //head = newNode;
        return newNode;
    }

    /**
     * 尾插
     * @param head 原链表的头节点
     * @param val 要插入结点的值
     * @return 完成尾插操作后链表的头节点
     */
    private static ListNode pushBack(ListNode head, int val) {
        if (head == null) {
            return pushFront(head, val);
        } else {
            ListNode newNode = new ListNode(val);
            ListNode last = getLast(head);
            last.next = newNode;

            return head;
        }
    }

    /**
     * 获取链表的最后一个结点
     * @param head 链表的头节点
     * @return 获取到的结点
     */
    private static ListNode getLast(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 链表的头删
     * @param head 链表的头节点
     * @return 完成头删操作之后链表的头节点
     */
    private static ListNode popFront(ListNode head) {
        if (head == null) {
            System.out.println("空链表无法删除!");
            return null;
        } else {
            return head.next;
        }
    }

    /**
     * 链表的尾删
     * @param head 链表的头节点
     * @return 完成尾删操作之后链表的头节点
     */
    private static ListNode popBack(ListNode head) {
        if (head == null) {
            System.out.println("空链表无法删除!");
            return null;
        } else if (head.next == null) {
            return popFront(head);
        } else {
            ListNode lastLast = getLastLast(head);
            lastLast.next = null;
            return head;
        }
    }

    /**
     * 获取链表倒数第二个结点
     * @param head 链表的头节点
     * @return 获取到的结点
     */
    private static ListNode getLastLast(ListNode head) {
        ListNode cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 逆置链表
     * @param head 原链表的头节点
     * @return 完成逆置之后链表的头节点
     */
    private static ListNode reverseLinkedList(ListNode head) {
        ListNode newList = null;
        ListNode cur = head;
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            while (cur != null) {
                ListNode next = cur.next;

                cur.next = newList;
                newList = cur;

                cur = next;
            }
        }
        return newList;
    }

    /**
     * 删除链表中的 val
     * @param head 链表的头节点
     * @param val 要删除的值
     * @return 完成删除之后链表的头节点
     */
    private static ListNode removeElements(ListNode head, int val) { //删除链表中的val
        ListNode prev = head;
        ListNode cur = head.next;

        if (head == null) {
            System.out.println("空链表无法删除!");
            return null;
        }

        while (cur != null) {
            if (cur.value == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }

        if (head.value == val) {
            head = head.next;
        }
        return head;
    }

    /**
     * 删除链表中的 val
     * @param head 链表的头节点
     * @param val 要删除的值
     * @return 完成删除之后链表的头节点
     */
    private static ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            System.out.println("空链表无法删除!");
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.value == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        if (head.value == val) {
            head = head.next;
        }
        return head;
    }

    /**
     * 获取链表的长度
     * @param head 链表的头节点
     * @return 链表的长度
     */
    private static int getLinkedListLength(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }

    /**
     * 合并两个有序链表
     * @param head1 链表1的头节点
     * @param head2 链表2的头节点
     * @return 完成合并之后链表的头节点
     */
    private static ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            System.out.println("空链表任然为空!");
            return null;
        } else if (head1 == null) {
            return head2;
        } else {
            //找到第一个链表的最后一个结点
            ListNode last1 = getLast(head1);

            //让最后一个结点的 next 指向 第二个链表的头结点
            last1.next = head2;
            return head1;
        }
    }

    private static void test() {
        ListNode head = creatLinkedList();
        displayLinkedList(head);

        head = null;
        head = pushFront(head, 1);
        head = pushFront(head, 2);
        head = pushFront(head, 3);
        //期待结果 3 --> 2 --> 1 --> null
        displayLinkedList(head);

        head = pushBack(head, 10);
        head = pushBack(head, 20);
        head = pushBack(head, 30);
        //期待结果 3 --> 2 --> 1 --> 10 --> 20 -- > 30 -- > null
        displayLinkedList(head);

        head = popFront(head);
        //期待结果 2 --> 1 --> 10 --> 20 -- > 30 -- > null
        displayLinkedList(head);

        head = popBack(head);
        //期待结果 2 --> 1 --> 10 --> 20 -- > null
        displayLinkedList(head);

        head = reverseLinkedList(head);
        //期待结果 20 --> 10 --> 1 --> 2 -- > null
        displayLinkedList(head);

        head = null;
        head = pushFront(head, 1);
        head = pushFront(head, 3);
        head = pushFront(head, 1);
        head = pushFront(head, 5);
        head = pushFront(head, 1);
        head = pushFront(head, 3);
        head = pushFront(head, 1);
        //期待结果 1 --> 9 --> 1 --> 5 --> 1 --> 3 --> 1 --> null
        displayLinkedList(head);

        head = removeElements(head, 1);
        //期待结果 9 --> 5 -- > 3 --> null

        displayLinkedList(head);

        head = removeElements1(head, 3);
        //期待结果 5 -- > null
        displayLinkedList(head);

        ListNode head1 = null;
        head1 = pushFront(head1, 5);
        head1 = pushFront(head1, 3);
        head1 = pushFront(head1, 1);
        //期待结果 1 --> 3 --> 5 --> null
        displayLinkedList(head1);

        ListNode head2 = null;
        head2 = pushFront(head2, 7);
        head2 = pushFront(head2, 5);
        head2 = pushFront(head2, 2);
        head2 = pushFront(head2, 1);
        head2 = pushFront(head2, 1);
        //期待结果 1 --> 1 --> 2 --> 5 --> 7 -->  null
        displayLinkedList(head2);

        head = mergeTwoList(head1, head2);
        //期待结果 1 --> 3 --> 5 -- > 1 --> 1 --> 2 --> 5 --> 7 --> null
        displayLinkedList(head);
    }

    public static void main(String[] args) {
        test();
    }
}