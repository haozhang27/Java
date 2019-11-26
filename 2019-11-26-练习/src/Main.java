/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/26
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int y1 = 1;
        int y2 = -2;
        int y3 = 3;
        int y4 = 4;
        System.out.println(practice1.countOfSweets(y1, y2, y3, y4));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int row = 3;
        int col = 2;
        System.out.println(practice2.countOfCakes(row, col));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
