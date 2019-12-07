
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {1, 3, 5, 7, 9};
        int element = 5;
        System.out.println(practice1.index(arr, 5));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        practice2.change();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
