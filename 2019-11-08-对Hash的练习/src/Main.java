/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/08
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String s = "pwwkew";
        System.out.println(practice1.lengthOfLongestSubString(s));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        String[] srt = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(practice2.groupAnargms(srt));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
