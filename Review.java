/**
 * 链表的结点类
 *
 * @author haozhang
 * @date 2019/09/07
 */
class ListNode {
    public ListNode next;
    public int value;

    public ListNode (int val){
        this.next = null;
        this.value = val;
    }

    public String toString() {
        return String.format("Node(%d)", value);
    }

}

/**
 * 链表习题的的方法类
 *
 * @author haozhang
 * @date 2019/09/07
 */
class Method {
    /**
     * 对链表的遍历
     * @param head 链表的头结点
     */
    public void displayLinkedList(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.printf("(%d) --> ", cur.value);
        }
        System.out.println("null");
    }

    /**
     * 以给定值x为基准将链表分割为两部分，所有小于x的结点排在大于或等于x的结点之前。
     *     注意分割之后保持原来的数据顺序不变
     *
     * @param head 链表的头结点
     * @param x 基准值
     * @return null 表示链表为空链表；其他表示 分割后的链表
     */
    public ListNode pratition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        //数值较小的链表
        ListNode smallNumberList = null;
        ListNode smallNumberListLast = null;

        //数值较大的链表
        ListNode bigNumberList = null;
        ListNode bigNumberListLast = null;

        for (ListNode cur = head; cur != null; cur = cur.next) {
            if(cur.value < x) {
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

    /**
     * 删除链表的重复结点
     *
     * @param head 链表的头结点
     * @return 删除重复结点之后的链表
     */
    public ListNode deleteDuplcation(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode front = head;
        ListNode cur = head.next;
        ListNode prev = new ListNode(1);
        prev.next = front;
        ListNode fake = prev;

        while(cur != null) {
            if (front.value != cur.value) {
                prev = front;
                front = front.next;
                cur = cur.next;
            } else {
                //要么 cur 为空;要么 cur.value != front.value
                while(cur != null && cur.value == front.value) {
                    cur = cur.next;
                }

                prev.next = cur;
                front = cur;
                if(cur != null) {
                    cur = cur.next;
                }

            }
        }

        return fake.next;
    }

    /**
     * 判断链表是否是回文链表
     *
     * @param head 链表的头结点
     * @return true 表示链表具有回文结构； false 表示链表不具有回文结构
     */
    public boolean chkPalindrome(ListNode head) {
        ListNode middleNode = getMiddleNode(head);
        ListNode head2 = reverseList(middleNode);
        ListNode node1 = head;
        ListNode node2 = head2;

        while(node1 != null && node2 != null) {
            if(node1.value != node2.value) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    /**
     * 获取链表的中间结点
     *
     * @param head 链表的头结点
     * @return null 表示该链表为空； 其他表示链表的中间结点
     */
    private ListNode getMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null) {
            fast = fast.next;
            if(fast == null) {
                break;
            }

            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 逆置链表
     * @param head 链表的头结点
     * @return null 表示该链表为空； 其他表示 逆置之后的链表
     */
    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode newList = null;
        if (head == null) {
            return null;
        } else if(head.next == null) {
            return head;
        } else {
            while(cur != null) {
                ListNode next = cur.next;

                cur.next = newList;
                newList = cur;

                cur = next;
            }
        }
        return newList;
    }

    /**
     * 获取两个链表的相同结点
     * @param head1 链表的第一个头结点
     * @param head2 链表的第二个头结点
     * @return null 表示没有相同结点； 其他表示 链表的相同结点
     */
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);

        ListNode longList = head1;
        ListNode shortList = head2;

        int diff = length1 - length2;
        if (length1 < length2) {
            longList = head2;
            shortList = head1;
            diff = length2 - length1;
        }

        for (int i = 0; i < diff; i++) {
            longList = longList.next;
        }

        while(longList != shortList) {
            shortList = shortList.next;
            longList = longList.next;
        }
        return longList;
    }

    /**
     * 获取链表的长度
     *
     * @param head 链表的头结点
     * @return 链表的长度
     */
    private int getListLength(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }
        return length;
    }

}


/**
 * 对链表习题的复习
 *
 * @author haozhang
 * @date 2019/09/07
 */
public class Review {
    private static void test1() {
        Method method = new Method();

        ListNode head = new ListNode(9);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(1);

        head.next = n2; n2.next = n3; n3.next = n4;
        n4.next = n5; n5.next = n6; n6.next = null;

        //期待结果 9 --> 5 --> 2 --> 7 --> 3 --> 1 --> null
        method.displayLinkedList(head);

        head = method.pratition(head, 3);
        //期待结果 2 --> 1 --> 9 --> 5 --> 7 --> 3 --> null
        method.displayLinkedList(head);
    }

    private static void test2() {
        Method method = new Method();

        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(5);

        head.next = n1; n1.next = n2; n2.next = n3;
        n3.next = n4; n4.next = n5; n5.next = null;

        head = method.deleteDuplcation(head);
        //期待结果 2 --> 3 --> null
        method.displayLinkedList(head);
    }

    private static void test3() {
        Method method = new Method();

        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);

        head.next = n1; n1.next = n2; n2.next = n3; n3.next = null;

        boolean result = method.chkPalindrome(head);
        //期待结果 true
        System.out.println(result);

    }

    private static void test4() {
        Method method = new Method();

        ListNode head1 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(9);

        head1.next = n1; n1.next = n2; n2.next = n3;
        n3.next = n4; n4.next = n5; n5.next = null;

        ListNode head2 = new ListNode(2);
        ListNode n6 = new ListNode(4);

        head2.next = n6; n6.next = n3;

        ListNode sameNode = method.getIntersectionNode(head1, head2);
        //期待结构 Node(6)
        System.out.println(sameNode);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
