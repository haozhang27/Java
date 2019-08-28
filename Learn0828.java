//导入 Arrays 包
import java.util.Arrays;
/**
 * java 对数组的定义和使用
 *
 * @author haozhang
 * @date 2019/08/28
 */
public class Learn0828{
	/**
	 * 静态初始化数组
	 */
	public static void initArray() {
		//在方法里直接初始化了数组
		int[] array = {1, 2, 3, 4};

		//foreach形式 遍历数组
		for (int item : array) {
			System.out.println(item);
		}
	}

	/**
	 * 打印数组
	 * @param array 要打印的数组
	 */
	public static void printArray(int[] array) {
		for (int item : array) {                 
			System.out.println(item);
		}
		
		for (int i = 0; i < array.length; ++i) {
			System.out.println(array[i]);
		}
	}

	/**
	 * 动态初始化数组，并且打印数组
	 */
	public static void printArray1() {
		//指定数组 array1 的长度为 10
		int[] array1 = new int[10];
		for(int i = 0; i < 10; ++i) {
			array1[i] = i;
			System.out.println(array1[i]);
		}
	}

	/**
	 * 更改 array 不会影响到实参，通过动态方式，将 array 指向新的数组。
	 * 引用指向新位置的更改，不会影响实参
	 * @param array 形参
	 */
	public static void method1(int[] array) {

		array = new int[10];
		for(int i = 0; i < 10; ++i) {
			array[i] = 100 + i;
		}
	}

	/**
	 * 改变数组的值
	 * 通过引用，更改实际数组中的值.实参可以感受到变化
	 * @param array 形参
	 */
	public static void method2 (int[] array) {
		array[0] = 2019;
	}

	/**
	 * 测试方法
	 */
	public static void testCopyArray() {
		int[] srcArray = {1, 3, 5, 7, 9};

		//拷贝数组，这里是 srcArray 和 destArray 指向不同的数组，改变互不影响
		int[] destArray = Arrays.copyOf(srcArray, srcArray.length);

		//打印srcArray 第一个元素 仍然是 1，这里 相当于拷贝了一份 srcArray
		destArray[0] = 2019;
		System.out.println(srcArray[0]);


		// copy 了引用，srcArray 和 destArray 指向相同的数组，所以改变互相可见
		int[] destRefArray = srcArray;
		destRefArray[0] = 222;
		//打印srcArray 第一个元素  是 222，这里是 引用改变了 srcArray 的值
		System.out.println(srcArray[0]);

										   
		// 利用 System.arraycopy 实现 copy，需要提前申请好空间
		int[] destSystemArray = new int[srcArray.length];
		System.arraycopy(srcArray, 0, destSystemArray, 0, srcArray.length);
		System.out.println(Arrays.toString(destSystemArray));

		//拷贝结束点，可以大于数组长度，大于部分用默认值填充
		int[] destcopyOfRange = Arrays.copyOfRange(srcArray, 0, 3);
		System.out.println(Arrays.toString(destcopyOfRange));
		
		boolean[] A = new boolean[6];

		//把一个数组全部填充为一个值
		Arrays.fill(A, true);
		System.out.println(Arrays.toString(A));

		//把一个数组的部分填充为一个值，填充结束点不能大于数组长度
		Arrays.fill(A, 3, 5, false);
		System.out.println(Arrays.toString(A));
		
		int[] C = {1, 6, 2, 4, 19, 35, 11};
		//对一个数组全部元素排序
		Arrays.sort(C);
		System.out.println(Arrays.toString(C));
	}

	/**
	 * 测试方法
	 */
	public static void testDefaultValue() {
		//数组中元素的值 享受默认值
		int[] array;

		//不初始化，每个元素都是默认值 0
		array = new int[10];
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		/*
		initArray();

		//给方法传参时，静态形式初始化数组
		//int[] array = new int[] {};
		int[] array = new int[] {1, 2, 3, 4};

		printArray(array);

		//动态初始化数组，并且打印
		printArray1();
		 */

		//Arrays.toString 是打印数组的一种方式，Arrays 需要 import java.util.Arrays;
		int[] array = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(array));

		// 改变的是形参，不会影响到实参
		method1(array);
		System.out.println(Arrays.toString(array));

		//改变的是实参，会影响打印结果
		method2(array);
		System.out.println(Arrays.toString(array));

		//数组的各种copy
		testCopyArray();

		//数组中元素享受默认值
		testDefaultValue();
		
	}
}



/*
Java数组的定义与使用

数组 （arrays）				数据类型	1.基本数据类型
	1.语法					2.引用数据类型
	    定义数组，初始化数组			  1.数组类型
	2.内存模型					  2.对象类型
	   用到的第一个引用类型			  3.接口类型
数组类型
 	保存一组其他类型的数据，元素类型（Element type)
	 int[]     /    double[]


1 数组的定义
	1.int[] intArray;
	2.double doubleArray;

和c兼容的方式
	1.int intArray[];
	2.double doubleArray[];
规则允许使用，规范不建议使用


2 数组的使用

2.1 数组的初始化过程  （数组长度是固定的）
	1.静态初始化的方式      //一般是在 用到已知数组所有元素时 使用
	    int[] array = {1，2，3，4，}；
	    int[] array = new int[] {1,2,3,4};     //用在给方法传参数的时候
	2.动态初始化的方式
	    int[] array = new int[数组的长度]；
	3.不初始化数组，指定一个 null 字面量
	    int[] array = null;                //null 是空引用

2.2 数组的下标访问 
  用括号 [] 指定具体的下标
	1.下标的类型一定是 int 型的
	2.下标的取值范围：数组长度为 n ，则下标取值范围[0, n-1]。
	如果下标越界就会报“java.lang.ArrayIndexOutOfBoundException”异常
2.3 数组本质
  数组本质上是对象（Object 类的派生类）
2.3.1 属性
	int[] array = ...;
	array.length          //求数组中元素的个数
2.3.2 方法


3 数组本质上是引用类型，是对象
    数组和基本数据类型有很大区别
3.1 数组左边的空间
	1.内存
	2.栈（Stack）	堆（Heap）
保存在栈的东西
      1.局部变量
      2.参数
参数的调用实质上是值传递
方法中的 参数 是 形参，main方法中的参数是 实参。


Java 的数组原生支持 java.util.Arrays 支持
	1. Arrays.toString   //用来打印数组
	2. Arrays.copyOf(数组，数组长度)    //复制一份数组 
	System.arraycopy(源数组名称，源数组开始点，目标数组名称，目标数组开始点，拷贝长度)
	3. Arrays.copyOfRange(源数组名称，拷贝开始点，拷贝结束点) [开始点，结束点)
	拷贝结束点 可以大于 array.length ，大于的部分用默认值填充
	4. Arrays.fill(源数组名称，填充值)  把一个数组全部填充成指定的值
	   Arrays.fill(源数组名称，填充起始点，填充结束点，填充值) [起始点，结束点)，结束点不能大于数组长度
	5. Arrays.sort | Arrays.parallelSort
	Arrays.sort(int[] 数组名称)    //这样是对数组全部元素由小到大排


4 默认值
默认值		0的各类表现
byte/short/int/long   0
float/double              0.0
char		 0x0000
boolean		 false
reference		 null
变量初始化时，默认给的值
	局部变量无法享受默认值
	参数没有默认值

可以享受默认值：
数组元素享受默认值-0
属性
静态属性

二维数组就是一个一维数组，这个一维数组中元素都是数组类型的。
*/

                                                                                                                                                                                                                                                                    