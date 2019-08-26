public class Learn0826 {
  //9*9乘法表程序
	public static void multiplicationTable() {
		//用 i 来表示行数，
		for(int i = 1;i <= 9;++i) {

			//用 j 来表示列数，列数取决于行数，是第几行就有几列；
			for(int j = 1; j <= i;++j) {
			//乘法表从  行数 * 列数（但是列数不能大于行数）   所以这里的第二层循环就是 j <= i
				System.out.printf("%d * %d = %d\t",i,j,i*j);
			}
			System.out.printf("%n");
		}
	}

	//Java定义变量的规则
	public static void learnIdentifier() {
		/*int 998;   //用数字开头，不可以
		int *aaa;  //用*开头，不能通过
		int $98;   //可以通过编译，不建议使用
		int 其实可以；  //编译可通过，但不要这样用；   这里能通过的原因是编译器把 汉字 当做 字母 来处理的
		int for；   //关键字不能用来当变量名 */
	}

	//Java的编码形式
	public static void learnUnicode() {
		String a = "中国";
		String b = "\u4e2d\u56fd";
		
		System.out.println(a);
		System.out.println(b);
	}

	//在定义变量和给变量赋初值的时候要注意变量可表示的数据范围
	public static void learnLiteral() {
		//byte a = 233;    //在编译时候会报错    //byte 表示最大范围 -128 ~ 127
		//byte b = 127;
		int a = 0xFF;
		int b = 0b11;
		int c = 99;
		System.out.println("a的值为："+ a);
		System.out.println("b的值为："+ b);
		System.out.println("c的值为："+ c);
	}

	//类型的转换：我们把 表示数据范围小的类型的变量转换成表示数据范围大的类型的变量是可以的
	public static void learnTypeCast() {
		//把表示数据范围小的变量  转换成  表示数据范围大的变量是不行的    可以强制转换，但是有可能会造成数据的丢失
		//在表示long类型的数据时需要在数据后面加上 L
		long a = 100L;
		int b = 100;

		//long  转为 int型需要强制转换
		int c = (int)a;

		//int 转为long  不需要强制转换
		long d = b;
		
		System.out.println("c的值为："+ c);
		System.out.println("d的值为："+ d);
		
	}
	
	public static void learnDefaultValue() {
		/* int a;   
		 System.out.println(a); */
		//这定义变量然后去输出变量是不行的，因为局部变量不支持默认值
		
		//使用局部变量，要么在定义的时候直接初始化；要么在使用之前修改局部变量的值
		//定义时候初始化
		int a = 100;

		//使用之前初始化
		int b;
		b = 10;
		
		System.out.println("a的值为:"+ a);
		System.out.println("b的值为:"+ b);
	}

	//程序求 六种类型可表示的范围
	public static void learnRange() {
		System.out.printf("byte 型的范围:%d ~ %d %n",Byte.MIN_VALUE,Byte.MAX_VALUE);
		System.out.printf("short 型的范围:%d ~ %d %n",Short.MIN_VALUE,Short.MAX_VALUE);

		//在这里int的范围已经超出了 %d可表示的范围
		System.out.println("int 型的范围:"+ Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);
		System.out.println("float 型的范围:"+ Float.MIN_VALUE + "~" + Float.MAX_VALUE);
		System.out.println("double 型的范围:"+ Double.MIN_VALUE + "~" + Double.MAX_VALUE);
		System.out.println("long 型的范围:"+ Long.MIN_VALUE + "~" + Long.MAX_VALUE);
	}

	//字符的输出
	public static void learnStringAdd() {
		int a = 3;
		int b = 4;

		//这里  要想输出 a+b 的值就需要给其加括号    不然就输出的时 a 和 b对应的值
		System.out.println("结果是"+ a + b);
		System.out.println("结果是"+ (a + b));
		System.out.println("5" + 2.2);
	}
	
	public static void learnOperation() {
		int a = 3;
		int b = 4;

		//三目运算符的表达式   变量类型 变量 = 布尔表达式 ？ 满足布尔表达式时赋值：不满足布尔表达式时赋值
		int z = a > b ? a+b : a-b;
		System.out.println(z);
	}
	
	public static void main(String[] args) {    
		multiplicationTable();
		learnUnicode();
		learnLiteral();
		learnTypeCast();
		learnRange();
		learnStringAdd();
		learnOperation();
	}
}

/*
Java中数据类型-运算符-变量的基础知识

一、命名变量名 的一些规则
1、必须以 字母、下划线、美元符 $  开头，包括中文都可以
2、之后的部分  可以是字母、下划线、美元符 以及数字
3、变量名的长度是可以无限长的  
4、变量名不可以和Java的关键字冲突
5、是大小写铭感的   int java；int Java；这是两个变量

二、命名的规范：
1、永远不要使用美元符和下划线命名 （下划线有个特例）
2、使用有意义的名字做变量名，包括缩写
3、不要使用中午和拼音命名
4、类名称       每个单词的首字母都大写         class HelloWorldApp 
     方法名称    单个单词除第一个单词外，首字母大写   int helloWorldApp
     变量名称
     常量（不可修改）  每个字母都大写，用下划线分割  final int COUNT_OF_COUNTS = 100；
5、类名称  和  变量名称     大概是个名词
    方法名称                       大概是个动词

对象： 1、状态（属性）    2、行为（方法）


三、数据类型
  1、基本数据类型（primitive data type）
       1、数值类型
             1、整形    byte    short   int  long
             2、浮点型   float   double
       2、布尔类型   boolean
       3、字符类型    char

  2、引用数据类型（reference data type）  

数据类型的比较：
数据类型   存储空间大小    取值范围                默认值
boolean    1位                  true/false
char          2字节              0x0000 - 0xFFFF      '\u0000'
byte          1字节	       没有无符号一说	
short	2字节
int	4字节
long	8字节
float	4字节               IEEE 754 标准	
double	8字节

char  类型里保存的不是一个 ASCII 编码，而是 Unicode 编码

一般有 ASCII   和  Unicode  字符编码标准
ASCII用7位来表示；Unicode用31位 。

我们现在认准 UTF-8 编码形式  

四、字面量 （Literal）
1、整型的字面量
     100                （int）
     100L    100l     （long）

     进制
     十进制      100       100L
     十六进制   0xFF      0xFFL
     二进制      0b1010   0b101L        binary

100（int   型的字面量）      byte a = 100；  byte b = 233；
                                         short
                                         long
100L（long 型的字面量）    int a = 100L； 这样把大范围数据赋值给小范围数据有可能存不下，所以这种情况是不行的

2、浮点型的字面量
   1.0     （double)
   1.0F      1.0f     （float）
 
    double  a = 1.0F；   //没问题
    float  b = 1.0；    //有问题 不允许

里氏转换原则：
      用一个大范围的变量放一个小范围的变量是当然可以的。

强制类型转换  （type cast）
long a = 100L；
int b = (int)a；

科学表示法
   double a = 1E3；
表示数字  还可以使用一些下划线等把数字标的更容易可读   例如10_0000_0000
   
小范围数据类型  a = 大范围数；   不允许的
小范围数据类型  b = 小范围数；    允许的

特例
byte a = 数值（-128~+127）  允许
short b = 数值（-2^15~+2^15-1)  允许


3、布尔类型的字面量      truse / false

char  以及 String 类型
字符          字符串

char c = '中'；      //用单引号
char c = '\u4e2d'; //用 Unicode 转义序列（Unicode escape sequence）

String s = “中国”;   //双引号

char 的转义字符
\n   \t   \b  \\    \'   \"   ...

String 的加法运算 
String a = “我爱”；   String b = “中国”；   a + b 结果   我爱中国


五、运算符

赋值运算符
     初始化
     修改值
     final int a = 100；   //a的值不能被修改
          a = 30；    再赋值的话就会编译出错

算术运算符  + - * / %
    / 向下取整除    5 / 3 = 1
   % 取余数

一元运算符   ++  --  +  +10  -10  !逻辑取反
  int a = 100；    a++；的值100；       a的值变为101
                          ++a；的值101；       a的值变为101

  !逻辑取反只能用于  Boolean 类型   
     int a = 10；   !a；   //C语言合法   Java是不合法的

比较运算符    
   ==  !=   >       >=     <     <=
条件运算符    &&   ||   ?:
      条件（只允许布尔类型）？结果1：结果2      如果条件真，表达式值为结果1，否则为结果2

    短路特性
       条件1 && 条件2     如果条件1 的结果是假（false）
       条件1 || 条件2         如果条件1 的结果是真（true）
位运算符
   ~  &  |   ^
 int a = 0b1111;  ~a == 0b0000;
                           0b1111 & 0b11 == 0b0011;   //这里注意0b11   就是  0b0011；
                           0b1010 | 0b11 == 0b1011;

       n^2    异或  0b1010 ^ 0b1101  == 0b0111;


位运算符
    <<     >>    >>>
  0b11000 << 2 == 0b11000_00   左移两位
  0b11000  >> 2  == 0b110       右移

>>   和     >>>区别
>>带符号右移     >>>不带符号右移

byte  a= 0b1000_1100;
a  >> 2 == 0b1110_0011;      前面补1
a >>> 2 == 0b0010_0011;     前面补0

instanceof     类型判断运算符
对象  instanceof  类型（类）   == true | false


六、一些需要注意的
1、0.6332 是双精度浮点数，double类型
2、System.out.println("5"+ 2.2);  这个的输出结果和 System.out.println( + a + b);的结果相同都是52.2
3、float f = 3.4;  若不声明，小数默认用 double 来表示。所以这里在编译的时候就会报错  
4、正确的写法应该是    float f = 3.4f;  表示这是一个float型的变量
5、&  称为逻辑 与  ；例如 表达式1 & 表达式2  只有当表达式1 和 表达式2 都为 true 时，整个表达式结果才为 true
    && 称为简洁与或短路与，只有两个表达式都是 true结果才是true。左边为false，不计算右边表达式直接得出 false

*/