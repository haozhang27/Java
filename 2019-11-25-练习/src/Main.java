/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/25
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        System.out.println(practice1.countOfGread());
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        practice2.shuffleCards();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
