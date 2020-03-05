import java.util.ArrayList;
import java.util.Arrays;
/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/05
 */
public class Main {
    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     * @param head 链表的头节点
     * @return 逆序的链表
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode head) {
        ArrayList<Integer> ret = new ArrayList<>();
        ListNode node = reverseList(head);
        for (ListNode cur = node; cur != null; cur = cur.next) {
            int val = cur.val;
            ret.add(val);
        }
        return ret;
    }

    /**
     * 逆置链表
     * @param head 链表的头
     * @return 逆置后链表的头节点
     */
    private static ListNode reverseList(ListNode head) {
        ListNode newList = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;

            cur.next = newList;
            newList = cur;

            cur = next;
        }
        return newList;
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序
     * 遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列
     * {4,7,2,1,5,3,8,6}，则重建二叉树并返回
     * @param pre 二叉树先序遍历的结果
     * @param in 二叉树中序遍历的结果
     * @return 重构好的二叉树的根节点
     */
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0) {
            return null;
        }

        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);

        int leftCount = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == rootVal) {
                leftCount = i;
                break;
            }
        }

        int[] leftPre = Arrays.copyOfRange(pre, 1, 1 + leftCount);
        int[] leftIn = Arrays.copyOfRange(in, 0, leftCount);
        TreeNode left = reConstructBinaryTree(leftPre, leftIn);
        root.left = left;

        int[] rightPre = Arrays.copyOfRange(pre, 1 + leftCount, pre.length);
        int[] rightIn = Arrays.copyOfRange(in, 1 + leftCount, in.length);
        TreeNode right = reConstructBinaryTree(rightPre, rightIn);
        root.right = right;

        return root;
    }

    private static void test1() {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        head.next = n1; n1.next = n2;
        n2.next = n3; n3.next = null;
        displayListNode(head);

        System.out.println(printListFromTailToHead(head));
    }

    private static void displayListNode(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.printf("%d --> ", cur.val);
        }
        System.out.println("null");
    }

    private static void test2() {
        int[] pre = new int[] {1,2,4,7,3,5,6,8};
        int[] in = new int[] {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre, in);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
