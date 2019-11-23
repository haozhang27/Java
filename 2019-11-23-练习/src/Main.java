/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/23
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int m = 4;
        System.out.println(practice1.getSequeOddNum(m));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {2, 2, 0, 0, 0, 3, 0, 0, 1, 0};
        System.out.println(practice2.countOfMin(arr));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
