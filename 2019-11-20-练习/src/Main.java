/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/20
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        System.out.println(practice1.lowestCommonMultiple(5, 6));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        practice2.mapKeyValue();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
