/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/06
 */
public class Practice2 {
    /**
     * 两两交换链表的节点
     * @param head 链表头节点
     * @return 交换后的头节点
     */
    public ListNode swapPairs(ListNode head) {
       ListNode pre = new ListNode(0);
       pre.next = head;
       ListNode temp = pre;
       while (temp.next != null && temp.next.next != null) {
           ListNode front = temp.next;
           ListNode last = temp.next.next;

           temp.next = last;
           front.next = last.next;
           last.next = front;

           temp = front;
       }
       return pre.next;
    }
}
