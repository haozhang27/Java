/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/04
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        practice1.scoreGPA();
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {1, 8, 6, 2, 5, 4, 7, 3};
        practice2.headSort(arr);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
