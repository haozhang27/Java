/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/19
 */
public class Practice2 {
    /**
     * 数组中逆序对的个数，采用快排思想
     * @param arr 给定的数组
     * @param n 数组大小
     * @return 逆序对个数
     */
    public int countOfReversed(int[] arr, int n) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ret++;
                }
            }
        }

        return ret;
    }

    public int count(int[] A, int n) {
        // write code here
        if (A.length == 0 || n == 0) {
            return 0;
        }

        return mergeSortRecursion(A, 0, n - 1);
    }

    public int mergeSortRecursion(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = (left + right) / 2;


        return mergeSortRecursion(arr, left, mid) + mergeSortRecursion(arr, mid + 1, right)
                + merge(arr, left, mid, right);
    }

    public int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        int inverseNum = 0;
        while(i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                index++;
                i++;
            } else {
                inverseNum += (mid - i + 1);
                temp[index] = arr[j];
                index++;
                j++;
            }
        }

        while(i <= mid) {
            temp[index] = arr[i];
            index++;
            i++;
        }

        while(j <= right) {
            temp[index] = arr[j];
            index++;
            j++;
        }

        for (int k = 0; k < temp.length; k++) {
            arr[left] = temp[k];
            left++;
        }

        return inverseNum;
    }
}
