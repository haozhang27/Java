import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/25
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {4, 3, 9, 9};
        int[] ret = practice1.plusOne(arr);
        System.out.println(Arrays.toString(ret));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        List<List<Integer>> ret = practice2.generate(5);
        System.out.println(ret);
    }

    private static void test3() {
        Practice3 practice3 = new Practice3();
        List<Integer> ret = practice3.getRow(5);
        System.out.println(ret);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
