/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/11
 */
public class Main {

    /**
     * 反转链表
     * @param head 链表头节点
     * @return 反转之后的头节点
     */
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;

            cur.next = newHead;
            newHead = cur;

            cur = next;
        }
        return newHead;
    }

    /**
     * 将两个有序链表合并为一个新的有序链表并返回
     * @param list1 链表1头节点
     * @param list2 链表2头节点
     * @return 合并后的头节点
     */
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }

    private static void test1() {
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        head.next = n1;  n1.next = n2;
        n2.next = n3; n3.next = n4;
        n4.next = n5; n5.next = null;
        displayList(head);

        ListNode newHead = reverseList(head);
        displayList(newHead);

    }

    private static void test2() {
        ListNode head1 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);

        ListNode head2 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);

        head1.next = n1;  n1.next = n2; n2.next = null;
        head2.next = n4; n4.next = n5; n5.next = null;
        displayList(head1);
        displayList(head2);

        ListNode newHead = merge(head1, head2);
        displayList(newHead);

    }

    private static void displayList(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.printf("(%d) --> ", cur.val);
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
