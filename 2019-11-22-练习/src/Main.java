import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/22
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        practice1.obamaProgramme(n, s);
        System.out.println();
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        String s1 = "99999999999999999999999999999999999999999999999999";
        String s2 = "1";
        practice2.sumOfNums(s1, s2);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
