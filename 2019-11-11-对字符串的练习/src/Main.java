/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/11
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String str1 = "aba";
        String str2 = "b";
        System.out.println(practice1.countOfPalindrome(str1, str2));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        String str1 = "They are students.";
        String str2 = "aeiou";
        System.out.println(practice2.deleteChar(str1, str2));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
