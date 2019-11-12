import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/12
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String[] words = new String[] {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(practice1.countCharacters(words, chars));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        String A = "this apple is sweet";
        String B = "this apple is sour";
        System.out.println(Arrays.toString(practice2.uncommonFromSentences(A, B)));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
