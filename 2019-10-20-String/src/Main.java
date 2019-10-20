/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/20
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String s = "  ";
        System.out.println(practice1.lengthOfLastWord(s));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(practice2.isPalindrome(s));
    }

    private static void test3() {
        Practice3 practice3 = new Practice3();
        String s = "abc";
        System.out.println(practice3.validPalindrome(s));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
