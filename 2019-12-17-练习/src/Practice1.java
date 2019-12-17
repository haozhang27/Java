/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/17
 */
public class Practice1 {
    /**
     * 如果每个数字都大于等于前面所有数字的和称其是完美序列
     * 给定一个序列,找出最长的一段连续子序列，满足它是完美的
     * @param arr 给定的序列
     * @return 最长子序列长度
     */
    public int countOfPerfect(long[] arr) {
        int preMax = 1;
        int max = 1;
        long sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum <= arr[i]) {
                sum += arr[i];
                max++;
            } else {
                sum = arr[i];
                if (max > preMax) {
                    preMax = max;
                    max = 1;
                }
            }
        }

        return preMax;
    }
}
