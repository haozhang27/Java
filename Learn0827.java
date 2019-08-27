/**
 * java 对语法和方法的学习
 *
 * @author haozhang
 * @date 2019/08/27
 */
public class Learn0827{
	/**
	 * 判断 n 是否大于10
	 * @param n
	 */
	public static void printIsGreatThan10(int n) {
		if (n > 10) {
			//linux 上的 回车 是用 “\n”来表示的
			//windows 上的 回车 是用 “\r\n”来表示的
			//在Java里 输出换行 要用 “%n”
			System.out.printf("%d 是大于 10 的 %n",n);
		}
	}

	/**
	 * 打印颜色-switch循环
	 * @param color
	 */
	public static void printColor(String color) {
		//switch 支持 String类型
		switch(color) {
			case "Red": 
				System.out.println("红色");
				break;
			case "Yellow":
				System.out.println("黄色");
				break;
			default:
				System.out.println("不知道的颜色!");
		}
	}

	/**
	 * foreach 形式循环
	 * 		等价于 for(i = 0;i < 数组长度;++i){
	 * 			    元素类型 变量名 = 数组[i];}
	 * @param array
	 */
	public static void foreach (int[] array) {
		for (int item : array) {           
			System.out.println(item);
		}
	}

	/**
	 * 数组的遍历
	 * array.length 表示的是数组的长度，数组元素下标是从 0 开始，所以 这里使用的是 <
	 */
	public static void find() {
		int[] array = {1,2,3,4,5,6,7};
		for (int i = 0;i < array.length;++i) {

			if (array[i] == 3) {
				//普通的 break
				break;
			}
		}
		
		int[] [] twoArray = {
			{1,2,3},
			{4,5,6},
			{7,8,9},
		};
		
		found:
			for (int i = 0;i < 3;i++) {
				for (int j = 0;j < 3;++j) {
					if (twoArray[i][j] == 5) {
						//带标签的 break 和 continue
						break found;
						//continue found;
					}
				}
			}
	}

	/*
	//这两个 sum 方法没有重定义
	int sum (int a,int b){
		break;
	}

	int sum (int a,int b,int c) {
		break;
	}

	//这个方法  就与 第一个sum方法重定义了
	void sum(int a,int b){
		break;
	}*/

	/**
	 * 递归思想求汉诺塔问题
	 * @param n 盘子数
	 * @param src 原柱子编号
	 * @param dest 目标柱子编号
	 */
	public static void hannoi (int n, int src, int dest) {
		if (n == 1) {
			System.out.printf("从 %d 移到 %d%n", src, dest);
		}
		else {
			//中间柱子
			int other = 3 - src - dest;
			hannoi(n - 1, src, other);
			System.out.printf("从 %d 移到 %d%n", src, dest);
			hannoi(n - 1, other, dest);
		}
	}

	/**
	 * 递归法求 n 的阶乘
	 * @param n n 为几，就求几的阶乘
	 * @return n的阶乘
	 */
	public static long factorial (int n) {
		//终止条件 1! = 1   0! = 1
		if (n == 0 || n == 1) {
			return 1;
		}

		//递推公式 n! == (n-1) * n
		return factorial(n - 1) * n;
	}

	/**
	 * 计算 m 的位数，m 一定为正整数
	 * @param m 要求位数的数
	 * @return m的位数
	 */
	public static long calcDigitNum(long m) {
		//用 digitNum 来记录位数，
		long digitNum = 0;

		//用 m 去 除 10，每除一次，m的位数将减少一位.直到 m = 0 结束 除 运算
		for (; m > 0; m = m / 10) {
			// m 的位数每减少一位 digitNum + 1，来获取 m 的位数
			++digitNum;
		}
		return digitNum;
	}

	/**
	 * 用公式 1 + 1/1！+ 1/2！+...来近似 e 的值
	 * @param k 求多少次
	 * @return 近似求得的 e 的值
	 */
	public static double valueE(int k) {
		// e 用来表示 公式求和的值.因为 阶乘 是从第一项算起的，
		//所以这里 e 的初值是第 0 项的值 1
		double e = 1;

		// fac 在这里用来存放 分母 的值
		double fac = 1;
		for(int i = 1; i <= k; i++) {
				fac = fac * i;

				//因为 1 是 int 型的，e 是 double 型的，
				//两者不兼容，所以要强制类型转换
				e = e + (double) (1 / fac);
		}
		return e;
	}

	/**
	 * 用公式 pi / 4 = 1 - 1/3 + 1/5 - 1/7 + ...来近似 pi 的值
	 * (第 n 项的值小于 1/10^-7 时近似值是准确的)
	 * @param n 计算次数
	 * @return 近似得的 pi 的值
	 */
	public static double valuePi(int n) {
		//pi4 来表示公式求和 pi/4 的值
		double pi4 = 0;

		//deno 来表示分母的 正负 及 大小
		double deno = 0;
		for (int i = 1; i <= n; ++i) {
			if(i % 2 == 0) {
				//表示 从第1项计数起 偶数项的分母
				deno = -(2*i - 1);
			} else {
				//表示 从第1项计数起 奇数项的分母
				deno = 2*i - 1;
			}
			//表示 求和公式
			pi4 = pi4 + (double) (1 / deno);
		}
		return 4 * pi4;
	}

	/**
	 * 逆置字符串
	 * @param s 字符串
	 * @return 逆置后的字符串
	 */
	public static String reverse(String s) {
		//计算字符串长度
		int length = s.length();

		// 定义一个空的 字符串 来准备存放逆置后的字符
		String r = "";

		//字符串的下标从 0，1，2... length - 1
		for (int i = length - 1; i >= 0; --i) {
			// 定义 ch 来存放遍历一次之后的字符
			char ch = s.charAt(i);
			r = r + ch;
		}
		return r;
	}

	/**
	 * 十进制 转为 十六进制
	 * @param dec
	 * @return
	 */
	public static String decToHex(int dec) {
		// 创建一个字符串来存放转换后的十六进制数；
	String hex = "";
		while (dec >= 16) {

			//创建 变量来记录 dec 与 16 求余的余数
			int remainber = dec % 16;

			//求余 一次之后，dec = dec / 16
				dec = dec / 16;

			// 余数如果是小于 10 的就直接拼接在 hex 的后边
			if (remainber < 10) {
				hex += remainber;
			} else {
				//余数大于 10 就要转换成 A B C的形式
				char ch = (char) ('A' + (remainber - 10));
				hex += ch;
			}
		}
		if (dec != 0) {
			hex += dec;
		}
		// 逆置一下hex，就是dec的十六进制表示
		return reverse(hex);
	}
	
	public static void main(String[] args) {
		// 参数 与 10 比较大小
		printIsGreatThan10(100);
		printIsGreatThan10(6);
		//printColor(args[0]);

		// 数组的遍历
		foreach(new int[] {1, 3, 5, 7, 9});

		// 汉诺塔问题
		//hannoi (6, 0, 2);

		// 求 n 的阶乘
		int n = 10;
		System.out.printf("%d! = %d%n", n, factorial(n));

		//把 String 类型的数字找出来
		long m = Long.parseLong("123");
		System.out.printf("%d 一共有 %d 位%n", m, calcDigitNum(m));

		//近似 e 的值
		double e = valueE(10);
		System.out.printf("e = %f%n", e);

		//近似 pi 的值
		double pi = valuePi(10000000);
		System.out.printf("pi = %f%n", pi);

		//逆置字符串
		System.out.println(reverse("Hello!"));

		//十进制 转成 十六进制 表示
		System.out.println(decToHex(78943));
	}
}



/*
Java语句和方法

1 语句
Java中的语句分为  顺序结构   分支结构   循环结构

1.1 Java分支语句

1.1.1 if语句
if （逻辑表达式）{    //和c语言不同的是，一定是逻辑结果
     条件真时执行的语句
}else {
  条件为假时执行的语句
}

1.1.2 switch语句
switch（int 类型 | String 类型 | Enum 类型 | char类型） {
	case 条件1：
		满足条件1时执行的语句；
		break；
	case 条件2：
		满足条件2时执行的语句；
		break；
	...
	default：
		内容不满足时执行的语句；
 }

1.2 Java循环语句
while（条件） {
 语句；
}

for （初始化；条件；后续动作）{
 语句；
}

do {
 语句；
}while（条件）

在Java中多了一种 for 的形式   foreach
for （元素类型 变量名：容量数组）{
}
等价于 for（int i = 0；i < 数组长度；++i）{
 元素类型 变量名 = 数组[i];
}

1.3 循环控制
continue ：当程序执行到该语句时会跳过当前循环的剩余部分，返回循环判断
break：退出整个循环

2.方法
2.1方法的组成
1. 限定符 （Modifers）   public/static
2. ** 返回值类型，如果没有返回值，要明确写 void
3. ** 方法名称，命名习惯：首个单词全小写，以后的单词首字母大写
4. ** 参数列表（Paramaters List）
     （）| （参数类型  参数名称）
5. 异常声明    throws  异常列表
6. ** 方法体 {}
带 ** 的都是一定要出现在一个方法当中的

例如 public static int calcSum（int[] array） throws Exception {
       1                 2    3              4                 5
         ... 6
       }    //标号对应方法组成中的标号内容

重点：关于方法签名 （Method signature）
             方法名称 + 参数列表

在 c 语言当中，函数名相同就表示两个函数重定义了；但是在Java中 方法名相同
只要参数列表不同就不是重定义。还有就是返回值类型是不算在函数签名当中
int sum（int a，int b）{}   与 void sum（int a，int b）{}  是重定义的
与int sum （int a，int b，int c）{}  不是重定义因为两个方法参数列表不同

方法名称相同，但参数列表不同  这样的方法称为重载。在通常情况下，不要写重载方法

2.2 递归方法
	在Java中，递归方法没有任何特殊性，与c语言一样
例如   long sum (int n) {     //求  1+2+...+n 的和的递归方法
           if (n == 1) {return 1;}
           else {return sum(n-1) + n;}
           }  

思想：
       数学归纳法思想
核心：不要在写递归时尝试展开递归过程

递归求解汉诺塔问题：
0号柱子		1号柱子		2号柱子
n == 1		把盘子从 原柱子 移到 目标柱子
n > 1		递归（n - 1）移到另外的柱子
		把最大的盘子移到目标
		递归（n-1）移到目标
*/
