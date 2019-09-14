/*
*形参/局部变量	挡掉属性
*/
class Shadowing {
	int size = 5;
	public void method(int size) {
		System.out.println(size);    //形参   100
		System.out.println(this.size);  //属性    5
	}
}
public class ShadowingExample {
	public static void main(String[] args) {
		Shadowing shadowing = new Shadowing();
		shadowing.method(100);
	}
}