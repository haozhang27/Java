/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        System.out.println(practice1.drink(20));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {1, 2, 3, 4, 5, 0};
        int n = 6;
        System.out.println(practice2.count(arr, n));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
