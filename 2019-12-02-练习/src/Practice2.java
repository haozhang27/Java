import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/02
 */
public class Practice2 {
    /**
     * 小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为
     *      * a.在接下来的一段时间内,他将会依次遇见n个怪物,每个怪物的防御力为b1,b2,b3...bn.
     *      * 如果遇到的怪物防御力bi小于等于小易的当前能力值c,那么他就能轻松打败怪物,并
     *      * 且使得自己的能力值增加bi;如果bi大于c,那他也能打败怪物,但他的能力值只能增加bi 与c的最大公约数.
     *      * 那么问题来了,在一系列的锻炼后,小易的最终能力值为多少?
     */
    public void countOfAbility() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ret = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= ret) {
                    ret += arr[i];
                } else {
                    ret += commonMeasure(arr[i], ret);
                }
            }
            System.out.println(ret);
        }
    }

    private int commonMeasure(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        int c = max % min;
        if (c == 0) {
            return min;
        }

        return commonMeasure(c, min);
    }
}
