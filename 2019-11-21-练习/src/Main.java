/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/21
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        System.out.println(practice1.deleteOfLast(7));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        System.out.println(practice2.countsOfZeros(5));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
