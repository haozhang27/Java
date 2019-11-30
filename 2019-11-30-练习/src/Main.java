/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/30
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String str1 = "ppRYYGrrYBR2258";
        String str2 = "YrR8RrY";
        System.out.println(practice1.isBuyGems(str1, str2));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        a.next = a1; a1.next = a2; a2.next = null;


        ListNode b = new ListNode(3);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(1);
        b.next = b1; b1.next = b2; b2.next = null;

        ListNode node = practice2.plusAB(a, b);

        for (ListNode cur = node; cur != null; cur = cur.next) {
            System.out.printf("(%d) --> ", cur.val);
        }
        System.out.println("null");

    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
