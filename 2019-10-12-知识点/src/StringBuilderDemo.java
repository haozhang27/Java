/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/12
 */
public class StringBuilderDemo {
    /**
     * 这样一共会创建 11 个对象  "" "0" "01" ... "012...9"
     */
    public static void test1 () {
        String s = "";
        int number = 10;
        for (int i = 0; i < number; i++) {
            s += i;
        }
        System.out.println(s);
    }

    /**
     * 这样创建了两个对象 sb 对象 和 s 对象
     */
    public static void  test2 () {
        StringBuilder sb = new StringBuilder();
        int number = 10;
        for (int i = 0; i < number; i++) {
            sb.append(i);
        }
        String s = sb.toString();
        System.out.println(s);
    }
    public static void main(String[] args) {
        test1();
        test2();
    }
}
