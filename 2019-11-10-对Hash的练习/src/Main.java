/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/10
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(practice1.isAnagram(s, t));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {2, 1, 2, 5, 3, 2};
        System.out.println(practice2.repeatedNTimes(arr));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
