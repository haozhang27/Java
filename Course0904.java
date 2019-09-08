
class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
public class Course0904 {
    /**
     * 链表的遍历
     * @param head 链表的头节点
     */
    public static void displayLinkedList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.printf("%d --> ", cur.value);
            cur = cur.next;
        }
        System.out.println("null");
    }

    /**
     * 链表的头插
     * @param head 链表的头节点
     * @param value 要插入的值
     * @return 插入之后链表的头节点
     */
    public static Node pushFront(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;

        return newNode;
    }

    /**
     * 链表的尾插
     * @param head 链表的头节点
     * @param value 要插入的值
     * @return 插入之后链表的头节点
     */
    public static Node pushBack(Node head, int value) {
        if (head == null) {
            return pushFront(head, value);
        } else {
            Node newNode = new Node(value);

            Node last = getLast(head);
            last.next = newNode;
            return head;
        }
    }

    /**
     * 获取链表的最后一个结点
     * @param head 链表的头节点
     * @return 获取到的结点
     */
    private static Node getLast(Node head) {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 链表头删
     * @param head 链表的头节点
     * @return 完成删除之后链表的头节点
     */
    public static Node popFront(Node head) {
        if (head == null) {
            System.out.println("无法删除空节点!");
            return null;
        } else {
            return head.next;
        }
    }

    /**
     * 链表尾插
     * @param head 链表的头节点
     * @return 完成尾插之后链表的头节点
     */
    public static Node popBack(Node head) {
        if (head == null) {
            System.out.println("删除位置不合法!");
            return null;
        } else if (head.next == null) {
            return popFront(head);
        } else {
            Node lastLast = getLastLast(head);
            lastLast.next = null;
            return head;
        }
    }

    /**
     * 获取链表的倒数第二个结点
     * @param head 链表的头节点
     * @return 获取到的结点
     */
    private static Node getLastLast(Node head) {
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 链表的逆置
     * @param head 链表的头节点
     * @return 完成逆置之后链表的头节点
     */
    public static Node reverseList(Node head) {
        Node newList = null;
        Node cur = head;
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            while (cur != null) {
                Node next = cur.next;

                cur.next = newList;
                newList = cur;

                cur = next;
            }
        }
        return newList;
    }

    /**
     * 删除单链表中的第一个 val
     * @param head 链表的头节点
     * @param val 要删除的值
     * @return 删除之后链表的头节点
     */
    public static Node removeElements(Node head, int val) {
        if (head == null) {
            System.out.println("空链表无法删除!");
            return null;
        }

        Node cur = head;
        while (cur.next != null) {
            if (cur.next.value != val) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        if (head.value == val) {
            return head.next;
        } else {
            return head;
        }
    }

    /**
     * 删除链表中的所以 val
     * @param head 链表的头节点
     * @param val 要删除的值
     * @return 完成删除操作之后链表的头节点
     */
    public static Node removeElements1(Node head, int val) {
        if (head == null) {
            System.out.println("空链表无法删除!");
            return null;
        }

        //用 prev 存储前驱结点
        Node prev = head;

        //从链表中第二个元素开始遍历
        Node cur = head.next;
        while (cur != null) {
            if (cur.value == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        if (head.value == val) {
            head = head.next;
        }
        return head;
    }




    public static void main(String[] args) {
        Node head = null;   //表示 head 指向的是空链表
        displayLinkedList(head);

        head = pushBack(head, 1);
        head = pushBack(head, 2);
        head = pushBack(head, 3);
        displayLinkedList(head);

        head = pushFront(head, 10);
        head = pushFront(head, 20);
        head = pushFront(head, 30);
        displayLinkedList(head);


        head = popFront(head);
        displayLinkedList(head);

        head = popBack(head);
        displayLinkedList(head);

        head = reverseList(head);
        displayLinkedList(head);

        head = null;
        head = pushFront(head, 1);
        head = pushFront(head, 3);
        head = pushFront(head, 4);
        head = pushFront(head, 1);
        head = pushFront(head, 5);
        head = pushFront(head, 1);
        head = pushFront(head, 3);
        head = pushFront(head, 7);
        head = pushFront(head, 3);
        head = pushFront(head, 2);
        displayLinkedList(head);

        head = removeElements(head, 1);
        displayLinkedList(head);

        head = removeElements1(head, 3);
        displayLinkedList(head);

    }
}
