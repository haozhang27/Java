import java.util.Scanner;

/**
 * 样例输入
 * 5
 *
 * 样例输出
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 *
 * @author haozhang
 * @date 2020/08/24
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            get(n);
        }
    }

    public static void get(int n) {
        int col0 = 1;
        int rowAdd = 2;
        for (int i = 0; i < n; i++) {
            int out = col0;
            System.out.print(out + " ");
            for (int j = 0; j < n - i - 1; j++) {
                out += rowAdd + j;
                System.out.print(out + " ");
            }
            System.out.println();
            col0 += i + 1;
            rowAdd++;
        }
    }
}
