/*
*遮蔽
*	变量  -->  类型名称  -->  包名
*/
import package_name.PackageClass;
public class ObscuringExample {
	public static void main(String[] args) {
		//变量的优先级：优先当成变量，其次当成类型，最后当成包名
		//int package_name = 10;
		System.out.println(PackageClass.NAME);
	}
}