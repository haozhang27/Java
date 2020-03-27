import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/27
 */
public class Main {
    /**
     * 判断树是否为平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalance(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }

        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);

        return Math.abs(left - right) > 1 ? false : isBalance(root.left)&&isBalance(root.right);
    }

    public int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        return left > right ? getTreeDepth(root.left) + 1 : getTreeDepth(root.right) + 1;
    }

    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
     * 如果有多对数字的和等于S，输出两个数的乘积最小的。
     * @param arr
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum(int [] arr,int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int num = arr[i] + arr[j];
                if (num == sum) {
                    ArrayList<Integer> ret = new ArrayList<>();
                    ret.add(arr[i]);
                    ret.add(arr[j]);
                    list.add(ret);
                }
            }
        }

        if (list.size() == 0) {
            return new ArrayList<>();
        } else if (list.size() == 1){
            return list.get(0);
        } else {
            ArrayList<Integer> product = new ArrayList<>();
            product.add(list.get(0).get(0));
            product.add(list.get(0).get(1));
            for (int i = 1; i < list.size(); i++) {
                List<Integer> sums = list.get(i);
                if (sums.get(0) * sums.get(1) < product.get(0) * product.get(1)) {
                    product.remove(0);
                    product.remove(1);
                    product.add(sums.get(0));
                    product.add(sums.get(1));

                }
            }
            Collections.sort(product);
            return product;
        }
    }
}
