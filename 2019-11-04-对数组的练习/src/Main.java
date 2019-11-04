
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/04
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[][] arr = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] ret = practice1.transpose(arr);

        System.out.printf("[");
        for (int i = 0; i < ret.length; i++) {
            System.out.printf("[");
            for (int j = 0; j < ret[0].length; j++) {
                System.out.printf("" + ret[i][j] + ",");
            }
            System.out.printf("]");
            if (i < ret.length - 1) {
                System.out.printf(",");
            }
        }
        System.out.printf("]");

        System.out.println();
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(practice2.maxArea(arr));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
