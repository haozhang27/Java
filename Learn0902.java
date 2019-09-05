
import java.util.Arrays;
/**
 * 对顺序表的学习
 *
 * @author haozhang
 * @date 2019/09/02
 */
public class Learn0902 {
	//this.array 指属性array
	private int[] array;
	private int size;

	/**
	 * 构造方法
	 * @param array 顺序表 array，array 是形参中的array
	 */
	public Learn0902(int[] array) {
		/**
		 * this.array 和 array 不是一回事
		 * 申请的空间至少需要 array.length 长
		 */
		this.array = new int[array.length];
		
		//把传入数组的所以元素 copy 到属性 array 中
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array[i];
		}
		
		//更新size
		size = array.length;
	}

	/**
	 * 在 index 处插入 element
	 * 时间复杂度 O(n)
	 * @param index 要插入的位置的下标
	 * @param element 插入位置的值
	 */
	public void insert (int index, int element) {
		ensureCapacity();
		
		if (index < 0 || index > size) {
			System.out.println("插入位置不合法:" + index);
			return;
		}
		
		for (int i = size - 1; i >= index; i--) {
			array[i + 1] = array[i];
		}
		array[index] = element;
		size++;
	}

	/**
	 * 删除 index 处的值,最坏情况  index == 0 时间复杂度O(n)
	 * 时间复杂度 O(n)
	 * @param index
	 */
	public void erase(int index) {
		if (index < 0 || index >= size) {
			System.out.println("删除位置不合法:" + index);
			return;
		}
		
		for (int i = index; i < size; i++) {
			array[i] = array[i + 1];
		}
		size--;
	}

	/**
	 * toString 方法
	 * @return 顺序表中非空的部分
	 */
	public String toString() {
		return Arrays.toString(
		   Arrays.copyOf(array, size));
	}

	/**
	 * 判断 插入过程中数组是否需要扩容
	 */
	private void ensureCapacity() {
		if (size < array.length) {
			return;
		}
		
		int newCapacity = array.length + array.length / 2;
		int[] newArray = new int[newCapacity]; 
		
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		
		array = newArray;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3 ,5, 6, 7, 8, 9, 11, 21, 32, 34};
		Learn0712 learn0712 = new Learn0712(array);
		System.out.println(learn0712.toString());
		
		learn0712.insert(1, 2);
		System.out.println(learn0712.toString());
		
		learn0712.erase(3);
		System.out.println(learn0712.toString());
	}
}