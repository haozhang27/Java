import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/02
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String s = "abcd";
        String t = "abcde";
        System.out.println(practice1.findTheDifference(s, t));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {3, 2, 1, 4};
        int[] ret = practice2.sortArrayByParity(arr);
        System.out.println(Arrays.toString(ret));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
