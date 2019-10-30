/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/30
 */
public class Practice2 {
    /**
     * 合并两个有序链表
     * @param head1 链表头节点
     * @param head2 链表头节点
     * @return 合并后的链表头节点
     */
    public ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else if (head1.val < head2.val) {
            head1.next = mergeTwoList(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoList(head1, head2.next);
            return head2;
        }
    }
}
