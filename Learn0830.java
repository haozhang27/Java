/**
 * Java 对类的练习
 *
 * @author haozhang
 * @date 2019/08/30
 */
class Person {
	private String name;
	private int age;
	
	//静态属性

	/**
	 * 有参构造方法
	 * @param name 姓名
	 * @param age 年龄
	 */
	public Person (String name, int age) {
		System.out.printf("Person(%s, %d)%n", name, age);
		this.name = name;
		this.age = age;
	}

	/**
	 * 无参构造方法
	 */
	public Person () {
		//this() 调用其他的构造方法, 必须出现在方法体的第一行
		this("学生", 18);
		System.out.printf("Person()%n");
	}
	
	public void print() {
		Person.printPerson(this);
	}
	
	public static void printPerson(Person person) {
		System.out.printf("Peraon{name = %s, age = %d}%n", 
		person.name, person.age);
	}
}

public class Learn0830 {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.print();
	}
}