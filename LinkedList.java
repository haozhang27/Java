
/**
 * Java对链表的认识
 *
 * @author haozhang
 * @date 2019/09/03
 */
class Node {
	public int value;   //保存结点中的数据
	public Node next;   //指向下一个结点的引用     特殊值 null
	
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
	
}

public class LinkedList {
	public static void displayLinkedList(Node head) {
		//如何遍历 一个链表
		for (Node cur = head; cur != null ; cur = cur.next) {
			System.out.printf("(%d) --> ", cur.value);
		}
		System.out.println("null");
	}
	
	public static Node createLinkedList() {
		Node n1 = new Node(1);    //首结点
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		return n1;
	}
	
	public static Node pushFront(Node head, int value) {
		//1.申请新结点
		Node newNode = new Node(value);
		//2.更新 newNode 的 next
		newNode.next = head;
		//3.更新 head
		//head = newNode;    //做了没问题，但没有实际影响，通常不做
		
		return newNode;
	}
	
	public static Node pushBack(Node head, int value) {
		if (head == null) {
			return pushFront(head, value);    //对空链表尾插
		} else {
			//对非空链表尾插
		    //1.申请新结点，让 next = null
			Node newNode = new Node(value);
			//2.找到当前的最后一个结点
			Node last = getLast(head);
			//3.让最后一个结点的 next = newNode
			last.next = newNode;
		  }
		
		return head;
	}
	
	public static Node getLast(Node head) {
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		return cur;
	}
	
	
	public static void main(String[] args) {
		Node head = createLinkedList();
		displayLinkedList(head);
		
		
		head = pushFront(head, 100);
		displayLinkedList(head);
		
		pushBack(head, 66);
		displayLinkedList(head);
		
	}
}
