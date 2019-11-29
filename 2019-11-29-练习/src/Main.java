import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/29
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int monthCount = 12;
        System.out.println(practice1.getTotalCount(monthCount));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(practice2.characterOfInput(s));
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
