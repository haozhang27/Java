/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/17
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        long[] arr = new long[] {1, 3, 9, 2, 6};
        System.out.println(practice1.countOfPerfect(arr));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        practice2.findMinx();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
