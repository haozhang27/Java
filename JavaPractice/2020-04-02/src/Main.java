/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/04/02
 */
public class Main {
    public ListNode deleteDuplication(ListNode head){
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode last = node;
        while(cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int val = cur.val;
                while(cur != null && cur.val == val) {
                    cur = cur.next;
                }
                last.next = cur;
            } else {
                last = cur;
                cur = cur.next;
            }
        }
        return node.next;
    }
}
