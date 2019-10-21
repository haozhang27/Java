/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/21
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        char[] arr = new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(practice1.compress(arr));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        String word = "falG";
        System.out.println(practice2.detectCapitalUse(word));

    }

    private static void test3() {
        Practice3 practice3 = new Practice3();
        String s = "aaaabcb";
        System.out.println(practice3.countSubstring(s));
    }

    private static void test4() {
        Practice4 practice4 = new Practice4();
        String s = "aaaabcb";
        System.out.println(practice4.countSubstring(s));
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
