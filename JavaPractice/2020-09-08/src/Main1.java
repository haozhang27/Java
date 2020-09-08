import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素[注: 题目更新了。输出之后有换行]
 *
 * @author haozhang
 * @date 2020/09/08
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int len1 = sc.nextInt();
            int[] arr1 = new int[len1];
            for (int i = 0; i < len1; i++) {
                arr1[i] = sc.nextInt();
            }

            int len2 = sc.nextInt();
            int[] arr2 = new int[len2];
            for (int i = 0; i < len2; i++) {
                arr2[i] = sc.nextInt();
            }

            combineBySort(arr1, arr2);
        }
    }

    public static void combineBySort(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        int[] ret = new int[set.size()];
        int i = 0;
        for (int n : set) {
            ret[i++] = n;
        }

        Arrays.sort(ret);

        for (int j = 0; j < ret.length; j++) {
            System.out.print(ret[j]);
        }
        System.out.println();
    }
}
