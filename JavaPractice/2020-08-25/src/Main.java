import java.util.Scanner;

/**
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月
 * 后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 *
 * @author haozhang
 * @date 2020/08/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int month = sc.nextInt();
            System.out.println(getTotalCount(month));
        }
    }
    public static int getTotalCount(int month) {
        int a = 1;
        int b = 0;
        int c = 0;
        while(--month > 0) {
            c += b;
            b = a;
            a = c;
        }
        return a+b+c;
    }
}
