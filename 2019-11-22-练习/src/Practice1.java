/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/22
 */
public class Practice1 {
    public void obamaProgramme(int n, String s) {
        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
        System.out.println();

        int row  = (int)Math.round((double)n / 2) - 2;
        for (int i = 0; i < row; i++) {
            System.out.print(s);
            for (int j = 1; j < n - 1; j++) {
                System.out.print(" ");
            }
            System.out.println(s);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
    }
}
