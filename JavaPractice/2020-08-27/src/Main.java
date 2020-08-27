import java.util.*;

/**
 * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
 * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 *
 * @author haozhang
 * @date 2020/08/27
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] weight = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = sc.nextInt();
            }

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(getCount(weight, nums));
        }
    }

    public static int getCount(int[] weight, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < num; j++) {
                list.add(weight[i]);
            }
        }

        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            Set<Integer> set1 = new HashSet<>(set);
            for (int n : set1) {
                set.add((n + num));
            }
        }
        return set.size();
    }

}
