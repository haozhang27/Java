import java.util.Arrays;
/**
 * 对数组的一些简单练习
 *
 * @author haozhang
 * @date 2019/08/28
 */
public class Practice0828 {
	/**
	 * 给定一个数组 找到数组中元素最大值
	 * @param array 给的的数组
	 * @return 数组中的最大值
	 */
	public static int max(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; ++i) {
			if(array[i] >= max) {
				max = array[i];
			}
		}
		return max;
	}
		/*
		//foreach形式
		for (int item : array) {
			if(array[i] >= max) {
				max = array[i];
			}
		}
		return max;
		*/

	/**
	 * 给定一个数组，找到key，返回key的下标
	 * @param array 给定的数组
	 * @param key 给定的数据
	 * @return 找到了返回下标，没找打返回 -1
	 */
	public static int indexOf(int[] array,int key) {
		for(int i = 0; i < array.length; ++i) {
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 评分系统，去掉一个最低分，去掉一个最高分，返回平均分
	 * @param scores
	 * @return
	 */
	public static double average(int[] scores) {
		//假设 最小值是 socres[0]
		int minValue = scores[0];

		//假设 最大值是 scores[0]
		int maxValue = scores[0];
		int sum = 0;   
		for(int i = 0; i < scores.length; ++i) {

			//找到 最低分
			if(scores[i] < minValue) {
				minValue = scores[i];
			}

			//找到最高分
			if(scores[i] > maxValue) {
				maxValue = scores[i];
			}
			
			sum += scores[i];
		}

		//scores 的长度一定大于3
		return (double) (sum - minValue - maxValue) / (scores.length - 2); 
	}

	/**
	 *复制数组
	 * @param src 要被复制的数组
	 * @param newLength 要复制的长度，可能 小于 大于 或者 等于 src.length
	 * @return 复制的数组
	 */
	public static int[] copyOf(int[] src, int newLength) {
		int[] dest = new int[newLength];

		//利用默认值特性 每个元素都是 0，确定 复制的数组的长度
		int minLength = src.length < newLength ? src.length : newLength;
		
		for(int i = 0; i < minLength; ++i) {
			dest [i] = src[i];
		}
		
		return dest;
	}

	/**
	 * 主方法
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] {0, 1, 2, 3, 4, 5};

		//找出数组中的最大数
		int maxValue = max(array);
		System.out.println("最大元素是：" + maxValue);

		//在数组中查找数
		int index = indexOf(array, 3);
		System.out.println("3的下标是 " + index);

		//计算平均分
		int[] scores = new int[] {97, 97, 98, 99, 100};
		double avarageValue = average(scores);
		System.out.println("平均分是" + avarageValue);

		//复制 数组
		System.out.println(Arrays.toString(copyOf(array, 3)));
		System.out.println(Arrays.toString(copyOf(array, 10)));
	}
}