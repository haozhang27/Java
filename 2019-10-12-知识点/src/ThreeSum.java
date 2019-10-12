import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/12
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum (int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> help = new ArrayList<>();
        int i = 0;
        int number = 2;
        while (i < nums.length - number) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                while (j < k && nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }

                if (j >= k) {
                    break;
                }

                if (nums[i] + nums[j] + nums[k] == 0) {
                    help.add(nums[i]);
                    help.add(nums[j]);
                    help.add(nums[k]);
                    ret.add(help);
                    k--;
                }
            }
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
