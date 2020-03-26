
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Main {
    /**
     * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表
     * ，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     * @param head1
     * @param head2
     * @return
     */
    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {

        int len1 = getLinkedListLen(head1);
        int len2 = getLinkedListLen(head2);

        ListNode longList = head1;
        ListNode shortList = head2;
        int diff = len1 - len2;
        if (len1 < len2) {
            longList = head2;
            shortList = head1;
            diff = len2 - len1;
        }

        for (int i = 0; i < diff; i++) {
            longList = longList.next;
        }

        while (longList != shortList) {
            longList = longList.next;
            shortList = shortList.next;
        }

        return longList;
    }

    private int getLinkedListLen(ListNode head) {
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        return len;
    }

    /**
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
     * （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }
}
