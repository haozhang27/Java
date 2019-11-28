/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/28
 */
public class Practice2 {
    /**
     * 把链表按照给定的基准值分割为两半
     * @param pHead 链表头节点
     * @param x 基准值
     * @return 分割之后的链表头节点
     */
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode smallNumberList = null;
        ListNode smallNumberListLast = null;

        ListNode bigNumberList = null;
        ListNode bigNumberListLast = null;

        if (pHead == null) {
            return null;
        }

        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                if (smallNumberList == null) {
                    smallNumberList = cur;
                } else {
                    smallNumberListLast.next = cur;
                }

                smallNumberListLast = cur;
            } else {
                if (bigNumberList == null) {
                    bigNumberList = cur;
                } else {
                    bigNumberListLast.next = cur;
                }

                bigNumberListLast = cur;
            }
        }

        if (smallNumberList == null) {
            return bigNumberList;
        } else {
            smallNumberListLast.next = bigNumberList;
            if (bigNumberListLast != null) {
                bigNumberListLast.next = null;
            }

            return smallNumberList;
        }
    }
}
