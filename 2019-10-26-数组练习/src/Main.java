/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/26
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {7, 1, 2, 4, 6};
        System.out.println(practice1.maxProfit(arr));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        System.out.println(practice2.fib(5));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
