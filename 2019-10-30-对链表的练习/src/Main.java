/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/30
 */
public class Main {
    private static void display(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " --> ");
        }
        System.out.println("null");
    }


    private static void test1() {
        Practice1 practice1 = new Practice1();
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        head.next = n2; n2.next = n3; n3.next = null;

        ListNode retHead = practice1.deleteDuplicates(head);
        display(retHead);
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        ListNode head1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        head1.next = n2; n2.next = n3; n3.next = null;

        ListNode head2 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        head2.next = n4; n4.next = n5; n5.next = null;

        ListNode retHead = practice2.mergeTwoList(head1, head2);
        display(retHead);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
