import java.math.BigInteger;
import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/11
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        char[] chars = new char[] {'3', 'a'};
        practice1.oddParity(chars);
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        practice2.bigNumberSort();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
