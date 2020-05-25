import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/05/25
 */
public class Main {
    /**
     *
     * @param x
     * @return
     */
    public int exchangeOddEven(int x) {
        String s = Integer.toBinaryString(x);
        StringBuilder sb = new StringBuilder(s);
        //保证每位都有与其交换的
        if (sb.length() % 2 == 1) {
            sb.insert(0, '0');
        }

        char[] arr = sb.toString().toCharArray();
        for (int i = 0; i < sb.length() - 1; i++) {
            int j = i + 1;
            swap(arr, i, j);
            //交换数是两两交换
            i++;
        }

        //把二进制数转换为十进制
        BigInteger bi = new BigInteger(String.valueOf(arr), 2);

        return Integer.parseInt(bi.toString());
    }

    /**
     * 数组交换
     * @param arr
     * @param i
     * @param j
     */
    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    /**
     * 数组A包含了0到n的所有整数，但其中缺失了一个。对于这个问题，我们设定限制，使得一次操作无法取得数组
     * number里某个整数的完整内容。唯一的可用操作是询问数组中第i个元素的二进制的第j位(最低位为第0位)，
     * 该操作的时间复杂度为常数，请设计算法，在O(n)的时间内找到这个数。
     * 给定一个数组number，即所有剩下的数按从小到大排列的二进制各位的值，如A[0][1]表示剩下的第二个数二
     * 进制从低到高的第二位。同时给定一个int n，意义如题。请返回缺失的数。
     *
     * 因为是0-N，所以只要判断数之间是否是偶数-奇数交替即可，哪一个数违反了该交替就返回该数
     * @param numbers
     * @param n
     * @return
     */
    public int findMissing2(int[][] numbers, int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 != numbers[i][0]) {
                return i;
            }
        }
        return n;
    }

    public int findMissing(int[][] numbers, int n) {
        //把 0-n 放入一个动态链表
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(i);
        }

        for (int i = 0; i < numbers.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = numbers[i].length - 1; j >= 0; j--) {
                sb.append(numbers[i][j]);
            }

            //把每个数的二进制转化为十进制
            BigInteger bi = new BigInteger(sb.toString(), 2);
            int num = Integer.parseInt(bi.toString());
            Object o = (Object)num;

            //在动态链表中删除该数
            list.remove(o);
        }

        //剩下的数就是要找的数
        return list.get(0);
    }
}
