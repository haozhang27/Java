/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/31
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {4, 3, 2, 7, 8, 3, 2, 1};
        System.out.println(practice1.findDisappearedNumbers(arr));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {1, 1, 0, 0, 1, 1, 1};
        System.out.println(practice2.findMaxConsectiveOnes(arr));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
