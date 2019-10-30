/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/30
 */
public class Practice1 {
    /**
     * 删除链表中的重复节点
     * @param head 链表的头节点
     * @return 删除之后链表的头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}

