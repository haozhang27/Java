import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/03
 */
public class Practice3 {
    /**
     * 二叉树先序遍历
     * @param root 二叉树的根节点
     * @return 遍历后的值
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                ret.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }

        return ret;
    }
}
