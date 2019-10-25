
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/25
 */
public class Practice1 {
    /**
     * 把一个非负数字放入到数组当中，给这个数字的最后一位加 1，
     * 返回加一之后数字所对应的数组
     * @param digits 描述数字的数组
     * @return 给数字加一之后描述数字的数组
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;

            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }

}
