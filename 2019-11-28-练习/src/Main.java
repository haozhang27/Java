/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/28
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] gifts = new int[] {2, 4, 3, 2, 2};
        int n = 5;
        System.out.println(practice1.getValue(gifts, n));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        ListNode pHead = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(2);

        pHead.next = n1; n1.next = n2; n2.next = n3;
        n3.next = n4; n4.next = n5; n5.next = null;
        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            System.out.printf("(%d) --> ", cur.val);
        }
        System.out.println("null");

        int x = 3;
        ListNode head = practice2.partition(pHead, x);

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
