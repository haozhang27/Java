import java.math.BigInteger;
import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Main {
    /**
     * 一副扑克牌,里面有2个大王,2个小王(一副牌原本是54张^_^)...随机从中抽出了5张牌,看能不能抽到顺子,
     * 大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。如果牌能组成顺子就输出true，否则就输出false。
     * 为了方便起见,认为大小王是0。
     * @param nums
     * @return
     */
    public boolean isContinuous(int [] nums) {
        Arrays.sort(nums);
        int count = countsZero(nums);
        int i = count;
        for (; i < nums.length - 1 && count >= 0; i++) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }

            if (nums[i] + 1 + count >= nums[i + 1]) {
                count -= nums[i + 1] - nums[i] - 1;
            } else {
                return false;
            }
        }

        if (i == nums.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    private int countsZero(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    /**
     *写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1,int num2) {
        while (num2 != 0) {
            int tmp = num1 ^ num2;
            num2 = (num1&num2) << 1;
            num1 = tmp;
        }
        return num1;
    }

    public int add2(int num1,int num2) {
        BigInteger bi1 = new BigInteger(String.valueOf(num1));
        BigInteger bi2 = new BigInteger(String.valueOf(num2));
        return bi1.add(bi2).intValue();
    }
}
