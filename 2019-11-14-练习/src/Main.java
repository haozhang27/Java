
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/14
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int n = 8;
        System.out.println(practice1.indexOfLastRemove(n));
        System.out.println(practice1.indexOfRemoveLast(n));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        practice2.numberOfFront();
    }
    public static void main(String[] args) {
        test1();
        test2();
    }
}
