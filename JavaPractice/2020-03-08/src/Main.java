/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/08
 */
public class Main {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法
     * @param target 台阶的阶数
     * @return 跳上target阶台阶的跳法
     */
    public static int jumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }

        int[] arr = new int[target + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= target; i++) {
            arr[i] = 0;
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j];
            }
        }

        return arr[target];
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
     * @param target 2*1矩阵的个数
     * @return 所有的方法数
     */
    public static int rectCover(int target) {
        if (target <= 1) {
            return target;
        }

        if (target == 2) {
            return 2;
        }

        return rectCover(target - 1) + rectCover(target - 2);
    }

    public static void main(String[] args) {
        System.out.println(jumpFloorII(5));
        System.out.println(rectCover(5));
    }

}
