import java.util.Arrays;
/**
 * 对数组的练习
 *
 * @author haozhang
 * @date 2019/08/29
 */
public class Practice0829 {

	/**
	 * 二分查找,查找前提是有序数组
	 * @param array 要查找数组
	 * @param key 要查找的元素
	 * @return -1 表示没找到， 其他表示 key 在数组中的位置
	 */
	public static int binarySearch(int[] array, int key) {
		int front = 0;
		int last = array.length;

		//在区间 [front, last) 上查找
		while (front < last) {
			int mid = front + (last - front) / 2;
				if (key < array[mid]) {
					//因为区间是左闭右开型的，所以要 比较 array[mid - 1] 右区间就要是 mid
					last = mid;
				}
				else if (key > array[mid]) {
					//左区间是 闭 的，所以就不需要再比较 array[mid] 直接比较 array[mid + 1]
					front = mid + 1;
				}
				else {
					return mid;
				}
		}
		return -1;
	}

	/**
	 * 交换 array[i] 和 array[j] 的位置，
	 * 因为修改 array[i] 对应的修改就是引用共同指向的数据，所以修改可以生效
	 * @param array 原数组
	 * @param i 要交换的下标
	 * @param j 要交换的下标
	 */
	public static void swap(int array[],  int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * 冒泡排序，减治算法
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; ++i) {
			//需要经过 array.length 次冒泡数组就有序了
			//冒泡过程就是在无序区间内，经过两两比较，把最大的数冒泡至最后
			
			boolean isSwapped = false;

			/**
			 * 无序部分：[0，array1.length - i)
			 * 有序部分：[array1.length - i，array1.length)
			 * 进行冒泡过程遍历整个无序区间
			 * 因为 array[j] 和 array[j+1] 比较，所以 j这里需要减 1
			 */
			for (int j = 0; j < array.length - i - 1; j++) {
				//冒泡过程中满足最大的数在最后面
				if (array[j] > array[j + 1]) {
					swap (array, j, j + 1);
					isSwapped = true;
				}
			}
			
			//如果一次完整的冒泡排序过程中，一次交换都没发生，表明数组有序，排序完成
			if (!isSwapped) {
				return;
			}
		}
	}
	
	
	
	public static void testPrint() {
		//println  只输出一个参数  并且换行
		System.out.println("中国人");
		System.out.println(1);
		System.out.println("中国人" + 1);
		System.out.println();
		
		//print 只输出一个参数 但是不会换行
		System.out.print("中国人");
		System.out.print(1);
		System.out.print("中国人" + 1);

		//Java中的换行 是 %n
		System.out.printf("我是中国人 %d %d%n", 1, 2);
		System.out.format("我是中国人 %d %d%n", 1, 2);
		
	}

	/**
	 * 逆置数组
	 * @param array 原数组
	 * @return 逆置之后的数组
	 */
	public static int[] changeArray(int[] array) {
		//数组的首元素地址
		int front = 0;

		//数组的尾元素地址
		int last = array.length - 1;

		//临时变量  用来存储 交换的值
		int temp = 0;
		while(front <= last) {
			temp = array[front];
			array[front] = array[last];
			array[last] = temp;

			//每逆置一次 首元素变为 (首元素 + 1) 的元素
			front++;

			//每逆置一次 尾元素变为 (尾元素 - 1) 的元素
			last--;
		}
		return array;
	}
	
	
	public static void main(String[] args) {
		//二分查找
		int[] array = new int[] {1, 2, 3, 4, 5};
		int index = binarySearch(array, 3);
		System.out.println("3 所在的下标是 " + index);

		//冒泡排序
		int[] bubbleArray = new int[] {3, 2, 9, 7, 4};
		bubbleSort(bubbleArray);
		System.out.println(Arrays.toString(bubbleArray));

		//数组逆置
		int[] changeArray = changeArray(array);
		System.out.println(Arrays.toString(changeArray));

		//Java的几种输出命令
		testPrint();
	}
}




/*
Java习题思路

1 二分查找的思路
    1.可以循环的条件是，front 和 last 确定的区间还有数，front < last
    2.根据 front 和 last 计算中间下标的位置
	int mid = (front + last) / 2；
	int mid = front + (front - left) / 2；
    3.比较 array[mid] 和 key (front,last)
	1.array[mid] == key   return mid;
	2.key < array[mid]      last = mid;
	3.key > array[mid]      left = mid + 1;

2 冒泡排序思路：
     1.对一个数组 第一个 和 第二个比较 大的往后排
     冒泡一次，可以让一个最大的数放到最后，一共经过 n 次 (n-1) 次

3 减治算法
    一次处理一个数，剩下的 n - 1 个数按相同方法处理

4 关于Java的输出命令
    System.out.println(String message);   //这个输出 message 并且自带输出换行
    System.out.print(String message);     //这个只输出 message
    无论 message 是什么类型，Java 都会将其转换为 String 类型

    System.out.printf(String format, 变长的参数);
    System.out.format(String format, 变长的参数);
    前面指定格式，后面跟参数             %d %f %s
*/
