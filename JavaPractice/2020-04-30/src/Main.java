import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/04/30
 */
public class Main {
    /**
     *从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> print(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            ret.add(new ArrayList<>());

            int levelLen = ret.size();
            for (int i = 0; i < levelLen; i++) {
                TreeNode node = queue.remove();
                ret.get(level).add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(arr, 3));
    }

    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他
     * 们的最大值分别为{4,4,6,6,6,5}；
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
     * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
     * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int[] num, int size){
        if (num.length == 0 || size == 0 || size > num.length) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length - size + 1; i++) {
            int start = i;
            int end = i + size;
            int ret = getMax(num, start, end);
            list.add(ret);
        }
        return list;
    }

    /**
     * 获取窗口内的最大值
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int getMax(int[] arr, int start, int end) {
        int ret = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (arr[i] > ret) {
                ret = arr[i];
            }
        }
        return ret;
    }
}
