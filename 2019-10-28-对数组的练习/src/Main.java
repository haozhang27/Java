/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/28
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {1, 2, 3, 1};
        System.out.println(practice1.containsDuplicate(arr));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {1, 2, 3, 5, 0};
        System.out.println(practice2.missingNumber(arr));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
