/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/24
 */
public class Main {
    public static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {1, 2, 3, 2};
        System.out.println(practice1.removeElement(arr, 2));
    }

    public static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr = new int[] {1, 2, 3, 5};
        System.out.println(practice2.searchInsert(arr, 4));
    }

    public static void test3() {
        Practice3 practice3 = new Practice3();
        int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(practice3.maxSubArray(arr));
    }

    public static void test4() {
        Practice4 practice4 = new Practice4();
        int[] nums1 = new int[] {1, 2, 3};
        int[] nums2 = new int[] {2, 4, 5};
        int m = 3;
        int n = 3;
        practice4.merge(nums1, m, nums2, n);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
