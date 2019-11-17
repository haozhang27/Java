/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/17
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String s = "abcd12345ed125ss123456789";
        System.out.println(practice1.continuousOfLongest(s));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        String s = "(()())";
        System.out.println(practice2.checkParenthesis(s, 6));

        String s2 = "()a()()";
        System.out.println(practice2.checkParenthesis2(s2, 7));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
