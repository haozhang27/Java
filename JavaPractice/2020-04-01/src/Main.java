import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Main {
    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
     * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重
     * 复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0 || length == 1) {
            duplication[0] = -1;
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int n = map.getOrDefault(num, 0);
            map.put(num, n + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val > 1) {
                duplication[0] = key;
                return true;
            }
        }

        return false;
    }


    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
     * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = product(A, i);
        }

        return B;
    }

    private int product(int[] arr, int n) {
        int[] arr1 = Arrays.copyOfRange(arr, 0, n);
        int[] arr2 = Arrays.copyOfRange(arr, n + 1, arr.length);
        int ret = 1;
        for (int i = 0; i < arr1.length; i++) {
            ret *= arr1[i];

        }

        for (int i = 0; i < arr2.length; i++) {
            ret *= arr2[i];

        }

        return ret;
    }
}
