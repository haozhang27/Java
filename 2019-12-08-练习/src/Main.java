
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/08
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int n = 25;
        System.out.println(practice1.isKeepTypeNumber(n));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        String s = "021Abc9000";
        System.out.println(practice2.isQualifiedPassWord(s));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
