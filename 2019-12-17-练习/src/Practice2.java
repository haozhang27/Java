import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/17
 */
public class Practice2 {
    /**
     * 定义 S(n)，表示 n 在十进制下的各位数字和。
     * 现在给定一个 x ,请你求出最小正整数 n，满足 x <= S(n)
     */
    public void findMinx() {
        Scanner input = new Scanner(System.in);
        int zu = input.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < zu; i ++) {
            list.add(input.nextInt());
        }
        for (int x : list) {
            System.out.println(func(x));
        }
    }

    public String func(int x) {
        int n = x / 9;
        String f = x % 9 == 0 ? "" : x % 9 + "";
        for (int i = 0; i < n; i ++) {
            f += "9";
        }
        return f;
    }
}
