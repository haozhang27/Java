import java.util.Arrays;
/**
 * 对数组的练习
 *
 * @author haozhang
 * @date 2019/08/31
 */
public class Learn0831 {
	/**
	 * 交换 array[i] 和 array[j] 的位置
	 * @param array 原数组
	 * @param i 要交换的下标
	 * @param j 要交换的下标
	 */
	public static void swap (int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * 冒泡排序
	 * @param array 要排序的数组
	 */
	public static void bubbleSort (int[] array) {
		int i = 0;
		int j = 0;
		for (i = 0; i < array.length; i++) {
			boolean isSwapped = false;
			for (j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					isSwapped = true;
				}
			}
			
			if (!isSwapped) {
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {2, 77, 0, 98, 44, 66, 12, 99};
		System.out.println(Arrays.toString(array));
		
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
} 