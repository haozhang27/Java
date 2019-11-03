import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/03
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {1, 3, -4, 10, 6};
        System.out.println(practice1.findMaxAverage(arr, 3));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {1, -2, 3, 6, 10};
        System.out.println(practice2.maximumProduct(arr));
    }

    private static void test3() {
        Practice3 practice3 = new Practice3();
        int[] arr = new int[] {4, 2, 3, 1};
        System.out.println(Arrays.toString(practice3.sortArrayByParity(arr)));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
