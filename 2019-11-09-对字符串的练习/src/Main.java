
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/09
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String s = "(()())";
        int length = s.length();
        System.out.println(practice1.chkParenthesis(s, length));
    }

    public static void main(String[] args) {
        test1();
    }
}
