import java.util.ArrayList;
import java.util.List;


/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/04/21
 */
public class Main {
    /**
     * 输入一个N，输出1-2+3-4+5-6+7......N的值。
     * @param n
     * @return
     */
    public static int sum(int n) {
        if (n < 1) {
            return 0;
        } else if (n % 2 == 1) {
            return (n - 1) / 2 + 1;
        } else {
            return -(n / 2);
        }
//        int ret = 0;
//        if (n <= 0) {
//            return 0;
//        }
//
//        for (int i = 1; i < n + 1; i++) {
//            if (i % 2 == 1) {
//                ret += i;
//            } else {
//                ret -= i;
//            }
//        }
//        return ret;
    }

    /**
     * 在相邻元素相差1的数组中查找某一特定元素第一次出现的位置
     * @param arr
     * @param target
     * @param len
     * @return
     */
    public static int getIndex(int[] arr, int target, int len) {
        int i = Math.abs(arr[0] - target);
        while (i < len){
            if (arr[i] == target) {
                return i;
            }
            i += Math.abs(arr[i] - target);
        }
        return -1;
    }

    /**
     * 给出一个非负整数数组，你最初定位在数组的第一个位置，数组中的每个元素的值代表你在
     * 那个位置可以跳跃的最大长度。判断你是否能到达数组的最后一个位置。
     * 例如：A = [2,3,1,1,4]，返回 true
     * A = [3,2,1,0,4]，返回 false
     * @param arr
     * @return
     */
    public static boolean isJump(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return true;
        }

        int flag = 0;
        while (flag < arr.length) {
            if (arr[flag] == 0) {
                return false;
            }

            flag += arr[flag];

            if (flag == arr.length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 任意输入一个字符串，输出它的所有子串
     * @param s
     * @return
     */
    public static List<String> getSubSet(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                list.add(s.substring(i, j + 1));
            }
        }
        return list;
    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();

        int row = matrix.length;
        while (row != 0) {

            for (int i = 0; i < matrix[0].length; i++) {
                ret.add(matrix[0][i]);
            }

            matrix = refactor(matrix);

            row = matrix.length;
        }
        return ret;
    }

    private static int[][] refactor(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] newMatrix = new int[col][row - 1];

        for (int j = col - 1; j >= 0; j--) {
            for (int i = 1; i < row; i++) {
                newMatrix[col - 1 - j][i - 1] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * 乌鸦喝水，1，1/2，1/4，每次喝前一次的一半，求前n次喝水的总数（分数表示）。
     * @param n
     */
    public static void sumOfDrink(int n) {
        int a = (int)Math.pow(2, n) - 1;
        int b = (int)Math.pow(2, n - 1);
        Nums nums = new Nums(a, b);
        System.out.println(nums.toString());
    }


    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * （买入和卖出一支股票一次），计算所能获取的最大利润。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > ret) {
                ret = prices[i] - min;
            }
        }
        return ret;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 计算所能获取的最大利润。（多次买卖一支股票）。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 计算所能获取的最大利润。最多可以完成 两笔 交易。
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int firstBuy = Integer.MAX_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int price : prices) {
            //第一次买的价格尽量小
            firstBuy = Math.min(firstBuy, price);

            //第一次卖的价格尽量多
            firstSell = Math.max(firstSell, price - firstBuy);

            //买完剩余的钱尽量多
            secondBuy = Math.max(secondBuy, firstSell - price);

            //第二次卖   当前价格为收益  +  上一次买入之后的收益
            secondSell = Math.max(secondSell, price + secondSell);
        }
        return secondSell;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 计算所能获取的最大利润。最多可以完成 k 笔交易。
     * @param prices
     * @param k
     * @return
     */
    public int maxProfit4(int[] prices, int k) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        if (k > n / 2) {
            k = (int)Math.floor(n / 2);
        }

        //最大收益
        int[] arr = new int[n];

        while (k-- > 0) {
            //第i天完成前k次交易所能获得的最大价值
            for (int i = 1; i < n; i++) {
                arr[i] = Math.max(arr[i], arr[i - 1] - prices[i - 1] + prices[i]);
            }

            //前i天完成前k次交易所能获得的最大价值。
            for (int i = 1; i < n; i++) {
                arr[i] = Math.max(arr[i], arr[i - 1]);
            }
        }
        return arr[n - 1];
    }

}

class Nums {
    int a;
    int b;
    public Nums(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a + "/" + b;
    }
}
