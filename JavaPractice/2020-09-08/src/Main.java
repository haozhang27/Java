import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 大数相加
 *
 * @author haozhang
 * @date 2020/09/08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            BigDecimal bigDecimal1 = new BigDecimal(s1);
            BigDecimal bigDecimal2 = new BigDecimal(s2);
            System.out.println(bigDecimal1.add(bigDecimal2));
        }
    }
}
