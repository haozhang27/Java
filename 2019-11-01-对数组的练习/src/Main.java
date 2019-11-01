/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/01
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {1, 2, 0, 4, 1};
        System.out.println(practice1.thirdMax(arr));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {1, 2, 4, 2, 5, 3, 4};
        System.out.println(practice2.findDuplicates(arr));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
