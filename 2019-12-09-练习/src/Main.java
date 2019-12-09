import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/09
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String[] arr = new String[] {"111111111111", "2222222222222222", "3333"};
        System.out.println(Arrays.toString(practice1.sort(arr)));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int n = 15;
        practice2.probabilityOfNotWin(n);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
