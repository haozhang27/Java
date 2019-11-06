
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/06
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        char[][] arr = new char[][] {{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(practice1.isValidSudoKu(arr));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head.next = n2; n2.next = n3; n3.next = n4;
        n4.next = null;

        ListNode retHead = practice2.swapPairs(head);
        for (ListNode cur = retHead; cur != null; cur = cur.next) {
            System.out.printf("(%d) --> ", cur.val);
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
       test1();
       test2();
    }
}
