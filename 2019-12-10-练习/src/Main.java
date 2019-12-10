/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/10
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        practice1.countOfSum();
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int a = 4;
        System.out.println(practice2.sumOfNum(a));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
