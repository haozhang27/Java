import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/27
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String[] p = new String[]{"a", "b", "c", "d"};
        int n = p.length;
        String s = "abc";
        System.out.println(Arrays.toString(practice1.chkSubStr(p, n, s)));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        practice2.scoreSort();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
