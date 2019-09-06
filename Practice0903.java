/**
 * Java 数据结构-链表
 *
 * @author haozhang
 * @date 2019/09/03
 */
class Node {
	public int value;
	public Node next;

	/**
	 * 构造方法
	 * @param value 结点的值
	 */
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
}

public class Practice0903 {
	/**
	 * 链表的遍历
	 * @param head 链表的头节点
	 */
	public static void displayLinkedList(Node head) {
		for (Node cur = head; cur != null; cur = cur.next) {
			System.out.printf("(%d) --> ", cur.value);
		}
		System.out.println("null");
	}


	/***
	 * 链表的头插
	 * @param head 链表的头结点
	 * @param value 要插入结点的值
	 * @return 完成插入之后链表的头节点
	 */
	public static Node pushFront(Node head, int value) {
		Node newNode = new Node(value);
		
		newNode.next = head;
		
		return newNode;
	}

	/**
	 * 链表的尾插
	 * @param head 链表的头节点
	 * @param value 要插入结点的值
	 * @return 返回完成插入之后链表的头节点
	 */
	public static Node pushBack(Node head, int value) {
		if (head == null) {
			return pushFront(head, value);
		}else {
			Node newNode = new Node(value);
			
			Node last = getLast(head);
			
			last.next = newNode;
			
			return head;
		}
	}

	/**
	 * 获取链表的最后一个结点
	 * @param head 链表的头节点
	 * @return 获取到的最后一个结点
	 */
	public static Node getLast(Node head) {
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		return cur;
	}


	/**
	 * 链表的头删操作
	 * @param head 链表的头节点
	 * @return 删除头节点之后链表的头节点
	 */
	public static Node popFront(Node head) {
		if (head == null) {
			System.out.println("参数不合法，无法删除空链表的结点！");
			return null;
		}
		return head.next;
	}

	/**
	 * 链表的尾删
	 * @param head 链表的头节点
	 * @return 完成尾删操作之后链表的头节点
	 */
	public static Node popBack(Node head) {
		if (head == null) { 
			System.out.println("参数不合法，无法删除空链表的结点！");
			return null;
		}
		
		if (head.next == null) {

			/**
			 * 链表中只有一个节点
			 * 视为头删解决
			 */
			return null;
		}else {
			//1.找到倒数第二个节点
			Node lastLast = getLastLast(head);

			//2.让倒数第二个节点的 next = null
			lastLast.next = null;

			//3.释放最后一个节点 (GC负责)
			return head;
		}
	}

	/**
	 * 获取链表的倒数第二个结点
	 * @param head 链表的头节点
	 * @return 获取到的结点
	 */
	public static Node getLastLast(Node head) {
		Node node = head;
		while (node.next.next != null) {
			node = node.next;
		}
		return node;
	}

	/**
	 * 逆置链表
	 * @param head 链表的头节点
	 * @return 逆置后链表的头节点
	 */
	public static Node reverseList(Node head) {
		//创建一个新的空链表
		Node newList = null;
		Node cur = head;
		while(cur != null) {
			// cur.next  的值会变化，先赋值给临时变量
			Node next = cur.next;

			//头插
			cur.next = newList;
			newList = cur;

			//让链表继续往下遍历
			cur = next;
		}
		return newList;
	}

	/**
	 * 逆置链表
	 * @param head 链表的头节点
	 * @return 逆置完成后链表的头节点
	 */
	public static Node reverseList1(Node head) {
		if (head == null) {
			return null;
		}
		
		Node n1 = null;
		Node n2 = head;
		Node n3 = head.next;
		
		while (n2 != null) {
			n2.next = n1;
			
			n1 = n2;
			n2 = n3;
			if (n3 != null) {
				n3 = n3.next;
			}
		}
		return n1;
	}

	/**
	 * 删除链表中的 value
	 * @param head 链表的头节点
	 * @param value 要删除的值
	 * @return 删除操作完成之后链表的头结点
	 */
	public static Node removeElements(Node head, int value) {
		if (head == null) {
			System.out.println("空链表无法删除!");
			return null;
		}
		
		Node cur = head;
		while (cur.next != null) {
			Node Next = cur.next;
			//如果当前节点的下一个值不是 value,继续判断下一个
			if (Next.value != value) {
					cur = cur.next;
			} else {
				//如果当前节点的下一个值是 value,则直接删除，当前的next，连接到当前next的next
				cur.next = cur.next.next;
			}
		}
		
		if  (head.value == value) {
			return head.next;
		} else {
			return head;
		}
	}
	
	
	public static void main(String[] args) {
		Node head = null;        
		displayLinkedList(head);

		//尾插
		head = pushBack(head, 1);
		head = pushBack(head, 2);
		head = pushBack(head, 3);
		displayLinkedList(head);

		//头插
		head = pushFront(head, 10);
		head = pushFront(head, 20);
		head = pushFront(head, 30);
		displayLinkedList(head);

		//头删
		head = popFront(head);
		head = popFront(head);
		head = popFront(head);
		// 预期结果 1 --> 2 --> 3 --> null
		displayLinkedList(head);
		
		head = popBack(head);
		// 期待结果 1 --> 2 --> null
		displayLinkedList(head);

		//尾删
		head = popBack(head);
		// 期待结果 1 --> null
		displayLinkedList(head);

		//尾删
		head = popBack(head);
		// 期待结果 null
		displayLinkedList(head);
		
		head = pushFront(head, 5);
		head = pushFront(head, 4);
		head = pushFront(head, 3);
		head = pushFront(head, 2);
		head = pushFront(head, 1);
		// 期待结果 1 --> 2 --> 3 --> 4 --> 5 --> null
		displayLinkedList(head);

		//逆置链表
		head = reverseList(head);
		// 期待结果 5 --> 4 --> 3 --> 2 --> 1 --> null
		displayLinkedList(head);
		
		head = reverseList1(head);
		displayLinkedList(head);
		
		head = null;
		head = pushFront(head, 1);
		head = pushFront(head, 3);
		head = pushFront(head, 1);
		head = pushFront(head, 5);
		head = pushFront(head, 1);
		// 期待结果 1 --> 5 --> 1 --> 3 --> 1 --> null
		displayLinkedList(head);
		
		head = removeElements(head, 1);
		// 期待结果 5 --> 3 --> null
		displayLinkedList(head);
	}
}





/*
Java 数据结构-链表

链表
    1.逻辑上有前后顺序
    2.不保证逻辑前后顺序的元素挨着


1 链表的遍历(完整遍历)
for (Node cur = head; cur != null; cur = cur.next) {}


Node cur = head;
while (cur != null) { cur = cur.next; }

2 链表的插入

2.1 头插() {
       newNode = 创建节点(value);
       newNode.next = head;
       更新 head 指向 value；
}

空的链表：一个节点都没有的链表
通过首节点表示一个链表    Node head = null；

2.2 尾插 {
      1.如果是空链表；就视为头插
      2.如果不是空链表  申请新节点
		 找到最后一个结点
		 更新最后一个节点的 .next 为新节点


3 链表的删除

3.1 头删
直接返回 head.next

3.2 尾删
1.找到倒数第二个节点，lastLast
2.lastLast.next = null
3.释放原来的最后一个节点 (GC 会负责处理)

子问题：如何找倒数第二个节点
while(cur.next.next != null) {
}

如果链表中只有一个节点，视为头删即可


4 链表的逆置
    1.首先定义一个新链表来记录头插的元素
    2.依次遍历原链表中的每个节点，头插到一个新的链表当中
    3.节点往下遍历

5 删除链表中所有的value
    1.首先定义一个 cur 记录当前结点
    2.判断当前结点的下一个节点是否是value。如果是，删除；如果不是，节点往下遍历
    3.走过所有结点之后，再判断头节点是否为 value
*/