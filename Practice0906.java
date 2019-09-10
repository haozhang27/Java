
class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int val) {
        this.value = val;
        this.next = null;
    }

    public String toString() {
        return String.format("Node(%d)", value);
    }
}

/**
 * 对链表的练习
 *
 * @author haozhang
 * @date 2019/09/06
 */
class LinkedList {
    /**
     * 创建一个链表
     * @return 返回链表的头节点
     */
    public ListNode creatLinkedList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = null;

        return n1;
    }

    /**
     * 遍历一个链表
     * @param head 链表的头节点
     */
    public void displayList(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.printf("(%d) --> ", cur.value);
        }
        System.out.println("null");
    }

    /**
     * 求中间结点（快慢，一个走两步，一个走一步）
     * 	 1）先求链表长度
     * 	 2）通过双引用遍历
     * 		1）特殊情况：
     * 		     1.假如链表没有k个长怎么办；长度是k个怎么办
     * 		     2.奇数情况需要和偶数情况一致
     * 		     3.检查周期
     *
     * @param head 链表的头节点
     * @return 返回 null 表示链表为空；其他表示链表的中间结点
     */
    public ListNode findMiddle(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 寻找链表倒数第 k 个结点
     * @param head 链表的头结点
     * @param k 要找倒数第 k 个
     * @return null 表示没有倒数第 k 个结点；其他表示倒数第 k 个结点
     */
    public ListNode findKthToTail1(ListNode head, int k) {
        int length = getListLength(head);
        if (length < k) {
            System.out.println("访问位置不合法!");
            return null;
        }

        ListNode kth = head;
        int n = length - k;
        for (int i = 0; i < n; i++){
            kth = kth.next;
        }

        return kth;
    }

    /**
     * 求倒数第K个结点（前后方式、前面的引用先走k步，然后一起走）
     * @param head 链表的头结点
     * @param k 求倒数第 k 个
     * @return null 表示没有倒数第 k 个；其他表示该结点
     */
    public ListNode findKthToTail2(ListNode head, int k) {
        ListNode front = head;
        ListNode cur = head;

        for (int i = 0; i < k; i++) {
            if(front == null) {
                return null;
            }
            front = front.next;
        }

        while(front != null) {
            cur = cur.next;
            front = front.next;
        }

        return cur;
    }

    /**
     * 获取链表长度
     * @param head 链表头结点
     * @return 链表的长度
     */
    private int getListLength(ListNode head) {
        int count = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            count++;
        }
        return count;
    }

    /**
     * 合并两个有序链表
     *      1.如果两个链表都还有结点，选择小的一个尾插到结果链表上
     *      2.直到一个链表全部结点都处理完了，把另一个链表额剩余部分接到结果链表尾部
     *
     * @param head1 第一个有序链表的头结点
     * @param head2 第二个有序链表的头结点
     * @return null 表示两个链表都是空链表；其他为合并后的链表
     */
    public ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if(head1 == null && head2 == null) {
            return null;
        }
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }


        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode resultList = null;
        ListNode last = null;
        while(cur1 != null && cur2 != null) {
            if(cur1.value <= cur2.value) {
                ListNode next = cur1.next;
                if(resultList == null) {
                    cur1.next = resultList;
                    resultList = cur1;
                } else {
                    cur1.next = null;
                    last.next = cur1;
                }
                last = cur1;
                cur1 = next;
            } else {
                ListNode next = cur2.next;
                if(resultList == null) {
                    cur2.next = resultList;
                    resultList = cur2;
                } else {
                    cur2.next = null;
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }

        return resultList;
    }

    /*
    *以给定值x为基准将链表分割为两部分，所有小于x的结点排在大于或等于x的结点之前。
    * 注意分割之后保持原来的数据顺序不变
    *   1.遍历整个链表，根据结点的值和x的关系，分别插入到 <x 的链表 或者 >=x 的链表中
    *   2.直接把 小于 和 大于等于的链表接起来
    *     特殊性：
    *       1.整个链表是空的
    *       2.没有小于x的
    *       3.没有大于等于x的
     */

    /**
     * 以给定值x为基准将链表分割为两部分，所有小于x的结点排在大于或等于x的结点之前。
     * 注意分割之后保持原来的数据顺序不变
     *          1.遍历整个链表，根据结点的值和x的关系，分别插入到 <x 的链表 或者 >=x 的链表中
     *         2.直接把 小于 和 大于等于的链表接起来
     *           特殊性：
     *             1.整个链表是空的
     *             2.没有小于x的
     *             3.没有大于等于x的
     *
     * @param head 链表的头结点
     * @param x 基准值
     * @return null 表示链表为空链表；其他表示分割后的链表
     */
    public ListNode pratition(ListNode head, int x) {
        //值小于 x 的链表
        ListNode smallNumberList = null;
        ListNode smallNumberListLast = null;

        //值大于 x 的链表
        ListNode bigNumberList = null;
        ListNode bigNumberListLast = null;


        if (head == null) {
            System.out.println("空链表无法分割!");
            return null;
        }

        //cur = cur.next 的目的是让 cur 指向 cur 原来的下一个结点
        for(ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.value < x) {
                if(smallNumberList == null) {
                    smallNumberList = cur;
                } else {
                    smallNumberListLast.next = cur;
                }
                smallNumberListLast = cur;
            } else {
                if(bigNumberList == null) {
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
            if(bigNumberListLast != null) {
                bigNumberListLast.next = null;
            }
            return smallNumberList;
        }

    }

    /**
     * 删除一个有序链表中的重复结点，重复的结点不保留
     *      使用两个引用(相邻的)遍历整个链表
     *          如果值不相等
     *                根据有序性：两个引用都往后走
     *          如果值相等
     *                让后边的引用前进，直到遇到不相等的结点或者null
     *                删除[front,cur)所有结点  front = cur,cur = cur.next(如果 p2 == null 怎么办)
     *                循环这个过程，直到 cur == null
     *
     *      1.删除结点，需要前驱结点
     *        如果最开始两个结点就相等，没有前序怎么办
     *            添加一个假的结点
     *
     * @param head 链表的头结点
     * @return 删除之后的链表的头结点
     */
    public ListNode deleteDuplication(ListNode head) {
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
                //或者 cur 为空、或者 cur.next 不等于 front.value
                while(cur != null && cur.value == front.value) {
                    cur = cur.next;
                }

                //删除从 [front,cur) 的所有结点
                    prev.next = cur;

                //这里 cur 可能为 null
                front = cur;
                if(cur != null) {
                    cur = cur.next;
                }
            }
        }
        return fake.next;
    }

    /**
     * 链表的回文结构，给定一个链表的头指针，返回一个bool值，代表其是否为回文结构
     *      1.先找到中间结点，然后以中间结点为头节点，逆置链表后半部分
     *      2.然后遍历两个链表 当两个链表对应结点的值都相等时，说明是回文链表
     *
     * @param head 链表的头结点
     * @return true 表示该链表具有回文结构；false 表示不具有回文结构
     */
    public boolean chkPalindrome(ListNode head) {
        ListNode midNode = findMiddle(head);   //找中间结点
        ListNode head2 = reverseList(midNode); //逆置链表
        ListNode node1 = head;
        ListNode node2 = head2;
        while(node1 != null && node2 != null){
            if(node1.value != node2.value) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;

    }

    /**
     * 逆置链表
     *      1.考虑链表为空 和 只有一个结点时怎么处理
     *      2.创建一个新链表，遍历原链表把原链表的结点尾插到新链表上
     *
     * @param head 链表的头结点
     * @return null 表示该链表为空；其他返回逆置之后的链表
     */
    public ListNode reverseList(ListNode head) {
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
     * 两个交叉链表求公共结点
     *      1.先计算这两个交叉链表的长度
     *      2.假定较长链表和较短链表
     *      3.让长一点的链表先遍历比短的链表多处的那部分；然后两个一起遍历直到 longList == shortList
     *
     * @param head1 链表的一个头结点
     * @param head2 链表的另一个头结点
     * @return null 表示没有公共结点；其他表示 交叉的结点
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

        //让长的链表先走 diff 步
        for (int i = 0; i < diff; i++) {
            longList = longList.next;
        }

        //同时前进直到 longList == shorList
        //可能都 == null ，表示没有交叉
        while(longList != shortList) {
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }


}
public class Practice0906 {

    private static void test1() {
        LinkedList linkedList = new LinkedList();

        ListNode head1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);

        head1.next = n2; n2.next = n3; n3.next = null;
        //期待结果 1 --> 1 --> 2 --> null
        linkedList.displayList(head1);

        ListNode head2 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);

        head2.next = n4; n4.next = n5; n5.next = null;
        //期待结果 1 --> 3 --> 5 --> null
        linkedList.displayList(head2);

        ListNode head = linkedList.mergeTwoList(head1, head2);
        //期待结果 1 --> 1 --> 1 --> 2 --> 3 --> 5 --> null
        linkedList.displayList(head);


        head = linkedList.creatLinkedList();
        //期待结果 1 --> 2 --> 3 --> 4 --> 5 --> null
        linkedList.displayList(head);

        ListNode middleNode = linkedList.findMiddle(head);
        //期待结果 Node(3)
        System.out.println(middleNode);

        ListNode kthNode1 = linkedList.findKthToTail1(head, 1);
        //期待结果 Node(5)
        System.out.println(kthNode1);

        ListNode kthNode2 = linkedList.findKthToTail2(head, 1);
        //期待结果 Node(5)
        System.out.println(kthNode2);
    }

    private static void test2() {
        LinkedList linkedList = new LinkedList();

        ListNode head = new ListNode(9);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(1);

        head.next = n2; n2.next = n3; n3.next = n4;
        n4.next = n5; n5.next = n6; n6.next = null;

        //期待结果 9 --> 5 --> 2 --> 7 --> 3 --> 1 --> null
        linkedList.displayList(head);

        head = linkedList.pratition(head, 3);
        //期待结果 2 --> 1 --> 9 --> 5 --> 7 --> 3 --> null
        linkedList.displayList(head);
    }

    private static void test3() {
        LinkedList linkedList = new LinkedList();

        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(7);
        ListNode n6 = new ListNode(7);

        head.next = n2; n2.next = n3; n3.next = n4;
        n4.next = n5; n5.next = n6; n6.next = null;

        head = linkedList.deleteDuplication(head);
        //期待结果 3 --> 5 --> null
        linkedList.displayList(head);
    }

    private static void test4() {
        LinkedList linkedList = new LinkedList();

        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);

        head.next = n2; n2.next = n3; n3.next = n4; n4.next = null;

        boolean result = linkedList.chkPalindrome(head);
        System.out.println(result);

    }

    private static void test5() {
        LinkedList linkedList = new LinkedList();

        ListNode head1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(8);

        ListNode head2 = new ListNode(2);
        ListNode n6 = new ListNode(4);

        head1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = null;
        head2.next = n6; n6.next = n4;

        ListNode node = linkedList.getIntersectionNode(head1, head2);
        System.out.println(node);
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
