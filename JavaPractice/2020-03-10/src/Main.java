import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/10
 */
public class Main {
    /**
     *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组
     * 的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的
     * 相对位置不变。
     * @param arr 数组
     */
    public static void reOrderArray(int [] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j]%2 == 0 && arr[j + 1]%2 == 1) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * @param head 链表的头节点
     * @param k 倒数k
     * @return 倒数第k个节点
     */
    public static ListNode findKthToTail(ListNode head,int k) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }

        if (count < k) {
            return null;
        }

        ListNode ret = head;
        for (int i = 0; i < count - k; i++) {
            ret = ret.next;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 2, 3, 5, 6};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));


        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        head.next = n1;  n1.next = n2;
        n2.next = n3; n3.next = n4;
        n4.next = n5; n5.next = null;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.printf("(%d) --> ", cur.val);
        }
        System.out.println("null");

        ListNode ret = findKthToTail(head, 3);
        System.out.println(ret.val);

    }
}
