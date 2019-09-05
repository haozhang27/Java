import java.util.Arrays;
/**
 * Java 数据结构-时间复杂度-顺序表
 * Sequence List
 * 顺序表中保存的数据元素类型 是 int
 *
 * @author haozhang
 * @date 2019/09/01
 */

public class SeqList {
	//用来保存数据
	private int[] array;
	//表示 array 中已有的数据个数
	private int size;

	/**
	 * 构造方法
	 */
	public SeqList() {
		/**
		 * 初始化部分
		 * 1.初始化 array，给定一个默认大小
		 * 2.初始化 size，没有数据，所以 size = 0
		 */
		array = new int[11];
		size = 0;
		
	}


	/**
	 * 头插
	 * 时间复杂度 O(n)
	 * @param element 要插入的值
	 */
	public void pushFront(int element) {
		//涉及插入操作时，首先要判断是否需要扩容
		ensureCapacity();
		
		//i 是数据下标，遍历范围是 [size - 1, 0]
		for (int i = size - 1; i >= 0; i--) {
			//必须从后往前搬，否则会覆盖数据
			array[i + 1] = array[i];
		}
		//把首地址的值 初始化为 element
		array[0] = element;
		size++;
		
	}

	/**
	 * 尾插
	 * 时间复杂度 O(1)
	 * @param element
	 */
	public void pushBack(int element) {
		ensureCapacity();
		
		array[size] = element;        
		size++;
	}

	/**
	 * 任意位置插
	 * 时间复杂度 O(n)
	 *
	 * @param index 插入的位置
	 * @param element 要插入的值
	 */
	public void insert(int index, int element) {
		ensureCapacity();
		
		if (index < 0 || index > size - 1) {
				System.out.println("插入位置不合法:" + index);
				return;
			}

		//i 代表的是数据下标
		for (int i = size - 1; i >= index; i--) {
			array[i + 1] = array[i];
		}
		array[index] = element;
		size++;
	}

	/**
	 * 头删操作
	 * 时间复杂度 O(n)
	 */
	public void popFront() {
		if (size == 0) {
			System.out.println("空顺序表，无法删除");
			return;
		}
		
		//i 表示数据下标
		for (int i = 0; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
		
	}

	/**
	 * 尾插操作
	 * 时间复杂度 O(1)
	 */
	public void popBack() {
		if (size == 0) {
			System.out.println("空顺序表，无法删除");
			return;
		}
		
		//先不考虑 size == 0 的情况
		array[size - 1] = 0;
		size--;
	}

	/**
	 * 任意位置删
	 * @param index 要删除数据的下标
	 */
	public void erase(int index) {
		if (index < 0 || index > size - 1) {
			System.out.println( "删除位置不合法:" + index );
		}
		
		//i 表示的是数据元素下标
		for (int i = index; i <= size - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
	}

	/**
	 * 获取 数组长度
	 * @return 数组长度
	 */
	public int capacity() {
		return array.length;
	}

	/**
	 * 根据数据求下标
	 * 时间复杂度 O(n)
	 *
	 * @param element 要返回下标的数据
	 * @return -1表示没找到，其他数据表示 element 的下标
	 */
	public int indexOf(int element) {
		for (int i = 0 ; i < size; i++) {
			if (array[i] == element){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 根据下标获取元素
	 * 时间复杂度 O(n)
	 *
	 * @param index 要找的下标
	 * @return array[index]
	 */
	public int get (int index) {
		if (index < 0 || index >= size) {
			System.out.println("下标不合法:" + index);
			return -1;
		}
		
		return array[index];
	}

	/**
	 * 修改 array[index] 的 element
	 * 时间复杂度 O(n)
	 * @param index 要修改元素的下标
	 * @param element 把 index 处的值修改为 element
	 * @return -1 表示修改位置不合法，其他数据表示修改后的 array[index]
	 */
	public int set (int index, int element) {
		if (index < 0 || index >= size) {
			System.out.println("下标不合法:" + index);
			return -1;
		}
		
		return array[index] = element;
	}

	/**
	 * 删除 array 中的一个 element
	 * 时间复杂度 O(n)
	 * @param element 要删除的值
	 */
	public void remove (int element) {
		int index = indexOf(element);
		if (index != -1) {
			erase(index);
		}
	}

	/**
	 * 删除 array 中所有的 elment
	 * @param element 要删除的值
	 */
	public void removeAll (int element) {
		/* 时间复杂度 O(n^2)   空间复杂度 O(1)
		int index;    
		while ((index = indexOf(element)) != -1) {
			erase(index);
		}*/
		
		/*
		//时间复杂度 O(n)   空间复杂度 O(n)
		int[] newArray = new int[size];

		// j 来表示不是 element 的数据的下标
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] != element) {
				newArray[j] = array[i];
				j++;
			}
		}
		//最后剩下的数一共有 j 个
		// 1.把数据搬回去 2.更新 size
		for (int i = 0; i < j; i++) {
			array[i] = newArray[i];
		}
		size = j;
		*/

		//时间复杂度 O(n)   空间复杂度 O(1)
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] != element) {
				array[j] = array[i];
				j++;
			}
		}
		//更新 size
		size = j;
	}
	
	//便于打印，显示顺序表已有元素
	public String toString() {
		return Arrays.toString (
		Arrays.copyOf(array, size) );
	}

	/**
	 * 内部使用的方法
	 * 无论是否需要扩容，调用完这个方法后，保证容量够用
	 */
	private void ensureCapacity() {
		if (size < array.length) {
			//不需要扩容
			return;
		}
		
		//1.申请新房子
		int newCapacity = array.length + array.length / 2;
		int[] newArray = new int[newCapacity];
		
		//2.搬家
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		
		//3.发朋友圈
		this.array = newArray;
		
		//4.退房子，利用 java 的垃圾回收，自动回收原来的数组
	}
	
	public static void test1() {
		SeqList seqList = new SeqList();
		
		System.out.println(seqList.toString());
		
		seqList.pushBack(1);     //尾插 1 2 3
		seqList.pushBack(2);
		seqList.pushBack(3);
		//[1, 2, 3]
		System.out.println(seqList.toString());
		
		seqList.pushFront(10);    //头插 10 20 30
		seqList.pushFront(20);
		seqList.pushFront(30);
		//[30, 20, 10, 1, 2, 3]
		System.out.println(seqList.toString());
		
		seqList.insert(2, 100);    //任意位置插入
		seqList.insert(4, 200);
		//[30, 20, 100, 10, 200, 1, 2, 3]
		System.out.println(seqList.toString());
		
		System.out.println("当前容量:" + seqList.capacity());
		seqList.pushBack(1000);     //带扩容的插入
		seqList.pushBack(2000);
		seqList.pushBack(3000);
		seqList.pushBack(4000);
		seqList.pushBack(5000);
		seqList.pushBack(6000);
		System.out.println(seqList.toString());
		System.out.println("当前容量:" + seqList.capacity());
		
		seqList.popFront();        //头删
		//[20, 100, 10, 200, 1, 2, 3, 1000, 2000, 3000, 4000, 5000, 6000]
		System.out.println(seqList.toString());
		
		seqList.popBack();         //尾删
		//[20, 100, 10, 200, 1, 2, 3, 1000, 2000, 3000, 4000, 5000]
		System.out.println(seqList.toString());
		
		seqList.erase(2);           //任意位置删
		//[20, 100, 200, 1, 2, 3, 1000, 2000, 3000, 4000, 5000]
		System.out.println(seqList.toString());
		
		int index = seqList.indexOf(200);  //获取 element 的下标
		//2
		System.out.println(index);
		
		int value = seqList.get(6);        //获取下标为 index 的元素值
		//1000
		System.out.println(value);
		
		seqList.set(3, 6);                //修改下标为 index 处的 element
		//[20, 100, 200, 6, 2, 3, 1000, 2000, 3000, 4000, 5000]
		System.out.println(seqList.toString());
	}
	
	public static void test2 () {
		SeqList s = new SeqList();
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		//[1, 2, 3, 4, 1, 2, 3, 4]
		System.out.println(s.toString());
		
		s.remove(2);        //删除 一个 element
		//[1, 3, 4, 1, 2, 3, 4]
		System.out.println(s.toString());
		 
		s.removeAll(4);    //删除 所有 element
		//[1, 3, 1, 2, 3]
		System.out.println(s.toString());
		
	}
	
	
	
	public static void main(String[] args) {
		test1();
		test2();
	}
}


/*
Java-数据结构-时间复杂度-顺序表

数据结构需要掌握的结构
  1.线性结构
  2.树形结构
  3.图形结构 （了解）
  4.排序

1 线性结构
  数据与数据之间呈现一种前后对应关系，应用最多。
      1.数据逻辑上有连续性；物理存储上也有连续性	顺序表
      2.数据逻辑上有连续性；物理存储上不一定连续	链表

1.1 顺序表
 顺序表是用一段物理地址连续的存储单元依次存储数据元素的线性结构，
一般情况下采用数组存储。在数组上完成数据的增删查改

 在访问第 n 个元素的时候，时间复杂度要求O(1)

顺序表的创建

增加元素   头插/尾插/插入(给定下标)
删除元素	头删/尾删/删除(给定下标)
查找元素   indexOf(element);
改变元素   set(int index, int value);       //O(1)
访问元素   get(int index);

1.1.1 尾插
  size 来表示数据元素的个数。做尾插操作时 size 也是尾插元素的下标
  只需要 array[size] = element;
1.1.2 头插
  1.需要从后往前遍历，否则数据会被覆盖
  2.数据下标的遍历范围 [size - 1, 0]
    空间下标遍历的范围 [size, 1]
  3.搬移过程    array[空间下标] = array[数据下标];
  4.空间下标 = 数据下标 + 1；
1.1.3 扩容
   1.扩容的条件
	在插入之前，size == array.length;
   2.如何扩容（搬家）
	1.申请新房子 (1.5倍 - 2倍)		一般Java中是1.5倍
	2.把东西都搬过去
	3.朋友圈通知
	4.把旧房子退掉
   3.所有的插入都要考虑扩容
头删、尾删等和头插尾插思路相同
1.1.4 删除顺序表中所有 element 
在编写算法时，时间复杂度和空间复杂度是需要我们细细斟酌的。尽量让算法时间复杂度为 O(n)
空间复杂度为 O(1) 。
   1.首先遍历顺序表
   2.判断 顺序表中的元素是否等于 element
   3.如果不等于 把元素 一次赋值给这个顺序表
   4.更新 顺序表 数据个数
*/