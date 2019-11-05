/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/05
 */
public class Practice1 {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
     * 找出给定目标值在数组中的开始位置和结束位置。
     *
     * @param nums 要查找的数组
     * @param target 要查找的数
     * @return 查找到的目标值在数组中的开始位置和结束位置数组
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[] {-1, -1};
        int left = binarySearch(nums, target);
        int right = binarySearch(nums, target);
        if (binarySearch(nums, target) == -1) {
            return ret;
        } else {
            while (right + 1 < nums.length && nums[right + 1] == target) {
                right++;
            }

            while (left - 1 >= 0 && nums[left - 1] == target) {
                left--;
            }

            ret[0] = left;
            ret[1] = right;
        }
        return ret;
    }


    /**
     * 二分查找
     * @param nums 要查找的数组
     * @param key 要查找的值
     * @return -1 表示没找到；其他表示 key 的下标
     */
    private int binarySearch(int[] nums, int key) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < key) {
                left = mid + 1;
            } else if (nums[mid] > key) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
