import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/29
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[]{1, 3, 5, 2};
        int[] changeArr = practice1.changeArray(arr);
        System.out.println(Arrays.toString(changeArr));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {1, 2, 3, 5};
        System.out.println(practice2.binarySearch(arr, 2));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

}
