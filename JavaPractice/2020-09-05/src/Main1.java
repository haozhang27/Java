import java.util.Scanner;

/**
 * 参数解析
 *
 * @author haozhang
 * @date 2020/09/05
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            System.out.println(arr.length);
            for (String s1 : arr) {
                System.out.println(s1);
            }
        }
    }
}
