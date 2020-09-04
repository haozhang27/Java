import java.util.Scanner;

/**
 * 提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 *
 * @author haozhang
 * @date 2020/09/04
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int x = 0; x <= 14; x++) {
                for (int y = 0; y <= 25; y++) {
                    if (7*x + 4*y == 100) {
                        int z = 100 - x - y;
                        System.out.println(x + " " + y + " " + z);
                    }
                }
            }
        }
    }
}
