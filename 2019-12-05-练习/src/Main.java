
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int n = 12;
        practice1.countOfNums(n);
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        practice2.countOfVotes();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
