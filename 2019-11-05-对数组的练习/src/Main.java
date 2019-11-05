import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/05
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {1, 3, 4, 4, 6};
        System.out.println(Arrays.toString(practice1.searchRange(arr, 4)));
    }

    public static void main(String[] args) {
        test1();
    }
}
