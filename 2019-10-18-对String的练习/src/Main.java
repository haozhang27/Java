/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/18
 */
public class Main {
    private static void test1() {
        String haystack = "hello";
        String needle = "ll";
        CharacterMatch characterMatch = new CharacterMatch();
        System.out.println(characterMatch.strStr(haystack, needle));

    }

    private static void test2() {
        KPM kpm = new KPM();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(kpm.strStr(haystack, needle));
    }

    private static void test3() {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(5));
    }

    private static void test4() {
        ReverseString reverseString = new ReverseString();
        char[] s = new char[] {'h', 'e', 'l', 'l', 'o'};
        reverseString.reverseString(s);
    }

    private static void test5() {
        Practice practice = new Practice();
        String s = "abstract";
        System.out.println(practice.fristUniqChar(s));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
