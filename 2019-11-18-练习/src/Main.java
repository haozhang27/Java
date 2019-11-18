/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/18
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {1, 2, 3, 3, 2, 3};
        System.out.println(practice1.countOfNum(arr));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        System.out.println(practice2.numOfGet());
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
