import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/05/08
 */
public class Main {
    TreeNode pre = null;
    public boolean checkBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!checkBST(root.left)){
            return false;
        }

        if (pre != null && pre.val >= root.val) {
            return false;
        }

        pre = root;

        return checkBST(root.right);
    }

    public boolean checkBST2(TreeNode root) {
        List<Integer> list = inorderTraversal(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) < list.get(i)) {
                return false;
            }
        }
        return true;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            retList.add(top.val);
            cur = top.right;
        }

        return retList;
    }
}
