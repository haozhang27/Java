import java.util.Arrays;
/**
 * Java 数据结构-复杂度
 *
 * @author haozhang
 * @date 2019/09/01
 */
public class Practice0901 {
	/**
	 * 交换 array[i] 和 array[j]
	 * @param array 原数组
	 * @param i 要交换的位置下标
	 * @param j 要交换位置下标
	 */
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * 冒泡排序
	 * @param array 原数组
	 */
	public static void bubbleSort(int[] array) {
		int i = 0;
		int j = 0;
		//需要经过 array.length 次排序
		for (i = 0; i < array.length; i++) {

			/**
			 * 有序区间 [array.length - i, array.length)
			 * 无序区间 [0, array.length - i)
			 */
			boolean isSwapped = false;

			//j 和 j+1 比较，j 要减去 1
			for (j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					isSwapped = true;
				}
			}
			
			if (!isSwapped) {
				return;
			}
		}
	}
	


	/**
	 * 二分查找
	 * 时间复杂度 1 ×2 ×2 ×2...×2 = n; 2^a = n; a = log2(n); 故O(log2(n))
	 * @param array1 查找的数组
	 * @param value 要查找的值
	 * @return -1 表示没找到 其他表示 value 的下标
	 */
	public static int binarySearch(int[] array1, int value) {
		int front = 0;
		//查找区间是 [front, last)
		int last = array1.length;
		while (front < last) {
			int mid = front + (last - front) / 2;
			if (array1[mid] == value) {
				return mid;
			} else if (array1[mid] > value) {
				last = mid;
			} else {
				front = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 求 n 的阶乘
	 * 时间复杂度 O(n)
	 * @param n 要求 n 的阶乘
	 * @return n 的阶乘
	 */
	public static long factorial(int n) {
		if (n < 2) {
			return 1;
		}
		return factorial(n - 1) * n;
	}

	/**
	 * 斐波那契数列
	 * 时间复杂度就是计算节点个数 F(n) = 2^0 + 2^1 +...+2^n-1 = 2^n - 1 = O(2^n)
	 * @param n 要求低第 n 项
	 * @return 斐波那契数列的第 n 项
	 */
	public static long fibonacci(int n) {
		if (n < 2) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	
	public static void main(String[] args) {
		int[] array = new int[] {1, 4, 3, 9, 5, 2};
		System.out.println(Arrays.toString(array));
		
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		
		int[] array1 = new int[] {1, 3, 5, 7, 8, 9};
		System.out.println(binarySearch(array1, 3));
		
		long fac = factorial(5);
		System.out.println(fac);
		
		long fib = fibonacci(5);
		System.out.println(fib);
	}
}




/*
Java数据结构-复杂度

1 模型
    Java中，内存简单分为 栈区|堆区|方法区
    栈区：存放局部变量、形参
    堆区：存放对象（属性信息）
    方法：存放类信息（方法信息、静态方法信息、静态属性）

    没有引用指向的对象 会被视为垃圾
  GC 处理的再好，也是有性能损耗的


2 普通属性的初始化
    1.在定义时直接初始化
    class A {}
    class B {
         A ref2 = new A();
    }
    2.在构造方法里初始化
    class A {}
    class B {
        A ref2;
        B() {
                 ref2 = new A();
             }
}
    3.在构造代码块中初始化
    1.如果定义多个构造代码块，Java编译器会保证按照定义顺序执行；
    2.可以视为把构造代码块的代码放到每个构造方法前执行；
        class A {}
        class B {
            A ref2;
            {
                 ref2 = new A();
            }
        }


3 静态属性初始化（发生在类被加载的时候）
    1.定义时初始化
     static A a = new A();
    2.静态代码块
    static {
         a = new A();
    }
    静态代码块，也是按照定义顺序执行


4 类加载 (了解)
     我们写的是 *.java 形式的文件，经过 javac 命令编译，
   变成 *.class文件(存放在硬盘上)，运行期间(JVM调用相应的类加载器)
   A.class 被 类加载器 加载到 方法区

5 复杂度（Complexity）
    衡量算法好坏的刻度尺/标杆，两个主要维度（时间|空间）
    
    1.时间复杂度（重点）
	第一反应：算法的运行时间
	因为运行环境的不确定，所以直接拿算法运行时间衡量不合理

	CPU 主频			单位时间内，运行的指令个数
                CPU 每秒运行的指令个数不变，所以我们去考察算法运行需要指令个数
	算法运行的指令个数和数据规模有关系，比如冒泡排序10个和1000个，指令个数=F(n)

	所以：
	  1.计算时间复杂度，先求 F(n)
   	da O 渐进表示法
	已知 F(n) = n^2 + 2*n + 10
	1.只保留最高项
	2.最高项的系数化为 1
	
	O(F(n)) = O(n^2)


6 算法需要考察多种情况
 最好		平均		最坏
 O(1)		O(n)		O(n)          给定数组，查找元素，返回下标的算法

考察算法的复杂度，一般来说只关注最差情况


6 空间复杂度
     1.算法用到的额外空间      2.和数据规模 n 有什么关系
     2.递归需要考虑调用栈
算法执行过程中，占用的额外空间和数据规模n的关系的大 o 渐进表示法
    开辟空间：
       1.堆上的局部变量/形参
       2.堆上的对象（数组、其他对象）
       3.如果是递归方法，考虑调用栈的占用情况

总结：复杂度（估算）
     衡量算法好坏刻度，有两个维度
     时间复杂度     1.通过算法使用的指令个数衡量
     空间复杂度
     大 O 渐进表示法   1.最高次项保留  2.系数 = 1
     常见复杂度
          O(1)  O(log(n))  O(n)  O(n*log(n))  O(n^2)
     二分查找 （包含完全二叉树）     O(log(n))
     递归：考虑调用栈（了解）
*/


