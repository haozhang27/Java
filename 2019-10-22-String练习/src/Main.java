/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/12
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String s = "PPALLL";
        System.out.println(practice1.checkRecord(s));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        String s = "Let's take LeetCode contest";
        System.out.println(practice2.reverseWords(s));
    }

    private static void test3() {
        Practice2 practice2 = new Practice2();
        String s = "Let's take LeetCode contest";
        System.out.println(practice2.reverseWords1(s));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
