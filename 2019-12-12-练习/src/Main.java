import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/12
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(practice1.countOfPalindrome(str1, str2));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {1, 3, 5, 2, 2};
        int n = 5;
        int k = 3;
        System.out.println(practice2.findKth(arr, n, k));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
