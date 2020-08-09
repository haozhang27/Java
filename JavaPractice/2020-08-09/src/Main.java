import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用
 * 计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，
 * 只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再
 * 把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“
 * 去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 *
 * @author haozhang
 * @date 2020/08/09
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            getSortNum(arr);
        }
    }

    public static void getSortNum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int j = 0;
        for (int num : set) {
            arr[j++] = num;
        }

        int[] nums = Arrays.copyOfRange(arr, 0, j);
        Arrays.sort(nums);
        for (int i = 0; i < j; i++) {
            System.out.println(nums[i]);
        }
    }
}
