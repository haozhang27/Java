/*  在类中不构造方法，main方法引用类的操作
//如何定义一个类
class Person {
	//定义属性
	String name;
	int age;
	
	//普通方法
	void print() {
		System.out.printf("name = %s, age = %d%n", name, age);
	}
}

public class Learn0829 {
	public static void main(String[] args) {
		//只定义了一个引用变量，没有创建真正的对象
		Person personNull = null;
	
		//如何根据类创建对象
		Person person = new Person();
		//使用对象
		//对象.属性
		//对象.方法
		person.name = "中国人";   //引用类属性
		person.age = 5000;		  //引用类属性
		person.print();          //引用类方法
		
		Person person1 = new Person();
		person1.name = "比特人";
		person1.age = 4;
		person1.print();
		
	}
}*/
/**
 * java 类 Person
 *
 * @author haozhang
 * @date 2019/08/29
 */
class Person {
	//定义属性
	String name;
	int age;
	
	//构造方法
	//1.在定义类的时候，没有明确的给出构造方法，Java编译器会
	//补一个默认的构造方法出来 Person() {} 参数是空的，方法体是空的
	//2.一旦明确定义过构造方法，不再有默认构造方法
	Person(String n, int a) {
		name = n;
		age = a;
	}
	
	//普通方法
	void print() {
		System.out.printf("name = %s, age = %d%n", name, age);
	}
}

/**
 * java 的类 Group
 *
 * @author haozhang
 * @date 2019/08/29
 */
class Group {
	//定义属性
	String name;
	int num;
	
	//构造方法：
	//1.没有返回值类型
	//2.方法名只能和类名相同
	Group (String n, int m) {
		name = n;
		num = m;
	}
	
	//普通方法：
	void print (String welcome) {
		System.out.printf("%s %s 的 %d 位学生%n", welcome, name, num);
	}
}

/**
 * java 的类 Number
 *
 * @author haozhang
 * @date 2019/08/29
 */
class Number {
	int sum;
	Number (int a, int b, int c) {
		System.out.println(a + b + c);
		sum = a + b + c;
	}
	
	void print() {
		System.out.println(sum);
	}
}


/**
 * java 的类和对象
 *
 * @author haozhang
 * @date 2019/08/29
 */
public class Learn0829 {
	public static void main(String[] args) {
		Person person = new Person("中国人", 5000);
		person.print();
		
		Group group = new Group("人工智能组的", 50);
		group.print("欢迎");
		
		Number number = new Number(1, 2, 3);
		number.print();
		
		/*
		//空引用 
		Number number2 = null;
		number2.print();    //NullPointerException  简称为NPE
		*/
	}
}




/*
Java的类和对象

1 面向对象的三大特性
    1.封装 2.继承 3.多态

2 如何定义类
[限定符] class 类名称        [继承定义]             [接口实现]                   {类体 class body}   
 public  class ClassName extends BaseClass implements Interface {
	属性
	方法
	内部类
} 

现阶段在定义类时只要限定符和类名称
public class ClassName {
	fileds;       属性
	methods;  方法
}

3 如何根据类创建对象
类名称 变量名；
变量名 = new 构造方法();

4 限定符
    public/private/什么都没有/protected

    [限定符] class ClassName {}
    public/什么都没有

    public class Learn0708 {}	 公开
    class Group {}                 	 包(package)内部

    class ClassName {
	[限定符]属性；	public/private/什么都没有
	[限定符]方法；
     }

     访问限定符	类内部	包内部	不是同一个包的其他类
     public		可访问	可访问	可访问
     空白		可访问	可访问	不可访问
     private		可访问	不可访问	不可访问
一般情况下，设置成 private 会更好一点

一个 Java 文件只能有一个 public 的类，而这个类的名称要和文件名一样，其他的类无所谓
*/