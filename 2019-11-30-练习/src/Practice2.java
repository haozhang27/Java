/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/30
 */
public class Practice2 {
    /**
     *有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，
     * 也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
     * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
     * @param a 头节点 a
     * @param b 头节点 b
     * @return 求和链表的头节点
     */
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode node = new ListNode(1);
        ListNode retNode = node;
        int retNum = 0;
        while (a != null && b != null) {
            node.next = new ListNode((a.val + b.val + retNum) % 10);
            retNum = (a.val + b.val + retNum) / 10;
            a = a.next;
            b = b.next;
            node = node.next;
        }

        while (a != null) {
            node.next = new ListNode((a.val + retNum) % 10);
            retNum = (a.val + retNum) / 10;
            a = a.next;
            node = node.next;
        }

        while (b != null) {
            node.next = new ListNode((b.val + retNum) % 10);
            retNum = (b.val + retNum) / 10;
            b = b.next;
            node = node.next;
        }

        if (retNum != 0) {
            node.next = new ListNode(retNum);
        }

        return retNode.next;
    }
}
