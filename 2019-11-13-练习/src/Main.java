import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/13
 */
public class Main {
    private static void test2() {
        Practice2 practice2 = new Practice2();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(practice2.lowestCommonMultiple(a, b));
        }
    }

    public static void main(String[] args) {
        test2();
    }

}
