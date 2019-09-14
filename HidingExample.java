/*
*隐藏的问题
*	1.子类的属性 隐藏掉 父类的属性
*	2.子类的静态属性隐藏掉父类的静态属性 
*	3.子类的静态方法隐藏掉父类的静态方法
*一定涉及到继承
*/
class Parent {
	int field = 1;
	static int staticField = 2;
	
	static void staticMethod() {
		System.out.println("父类的静态方法");
	}
}

class Child extends Parent {
	int field = 100;
	static int staticField = 200;
	
	static void staticMethod() {
		System.out.println("子类的静态方法");
	}
	
	public void method() {
		System.out.println(field);   		//100
		System.out.println(this.field);		//100
		System.out.println(super.field);	//1
	}
}

public class HidingExample {
	public static void main(String[] args) {
		Child object = new Child();
		
		System.out.println(object.field);  			//100
		System.out.println(object.staticField);		//200
		System.out.println(Child.staticField);			//200
		Child.staticMethod();							//子类的静态方法
		
		System.out.println(Parent.staticField);			//2
		Parent.staticMethod();							//父类的静态方法
	}
}