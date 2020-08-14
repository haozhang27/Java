import java.util.Scanner;

/**
 * 某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有n个空汽水瓶，她最多可以换多少瓶汽水喝？
 *
 * @author haozhang
 * @date 2020/08/14
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                continue;
            } else {
                System.out.println(getSoda(n));
            }
        }
    }


    public static int getSoda(int n) {
        //每次可以换几瓶
        int consult = 0;

        //换完之后手里剩余的瓶子
        int remainder = 0;

        //换完之后手里的总瓶子数
        int bottles = n;

        //总共换到的汽水
        int count = 0;
        while (bottles / 3 > 0) {
            consult = bottles / 3;
            count += consult;

            remainder = bottles - 3 * consult;

            bottles = consult + remainder;
        }

        if (bottles == 2) {
            count += 1;
        }

        return count;
    }
}
