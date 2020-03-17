import java.util.Stack;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Test {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean ret = false;
        //当root1和root2都不为空的时候，才进行比较
        if (root1 != null && root2 != null) {
            //在A树中如果找到了对应B的根节点 的 节点
            if (root1.val == root2.val) {
                //以这个节点为起点判断是否包含B树
                ret = isSubtree(root1, root2);
            }

            //如果不包含，就去A树的左子树找
            if (!ret) {
                ret = HasSubtree(root1.left, root2);
            }

            //如果不包含，就去A树的右子树找
            if (!ret) {
                ret = HasSubtree(root1.right, root2);
            }
        }
        return ret;
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        //如果B树已经遍历完，且A树都匹配返回true
        if (root2 == null) {
            return true;
        }

        //如果A树遍历完，B树没有遍历完
        if (root1 == null) {
            return false;
        }

        //有节点的值不相等
        if (root1.val != root2.val) {
            return false;
        }

        //根节点匹配，就去匹配其左右子树
        return isSubtree(root1.left, root2.left) &&
                isSubtree(root1.right, root2.right);
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode nodeLeft = node.left;
            TreeNode nodeRight = node.right;
            node.left = nodeRight;
            node.right = nodeLeft;

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
}
