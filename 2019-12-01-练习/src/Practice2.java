
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Practice2 {
    /**
     * 判断一棵树是否为平衡二叉树
     * @param root 给定的跟节点
     * @return true 表示是平衡二叉树； false 表示不是平衡二叉树
     */
    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return false;
        }

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1) {
            return false;
        }

        return true;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }
}
