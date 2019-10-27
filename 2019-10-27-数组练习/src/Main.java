import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/27
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {-4, -1, 0, 2, 1};
        System.out.println(Arrays.toString(practice1.sortedSquares(arr)));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {2, 1, 2, 2, 1, 2, 1};
        System.out.println(practice2.majorityElement(arr));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
