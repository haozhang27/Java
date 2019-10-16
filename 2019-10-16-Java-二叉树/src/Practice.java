
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/16
 */
public class Practice {
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        TreeNode tn1 = new TreeNode(2);
        TreeNode tn2 = new TreeNode(3);

        root.left = null; root.right = tn1;
        tn1.left = tn2; tn1.right = null;
        tn2.left = null; tn2.right = null;
        return root;
    }

    /**
     * 迭代算法
     * 二叉树的前序遍历
     * @param root 二叉树的根节点
     * @return 遍历完成之后二叉树节点值的数组
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
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

    /**
     * 递归写法
     * @param root 二叉树的根节点
     * @return 遍历之后二叉树的节点值数组
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> ret = new ArrayList<>();
        ret.add(root.val);
        ret.addAll(preorderTraversal2(root.left));
        ret.addAll(preorderTraversal2(root.right));

        return ret;
    }

    /**
     * 迭代算法
     * 二叉树的中序遍历
     * @param root 二叉树的根节点
     * @return 遍历完成之后的二叉树节点值数组
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    /**
     * 递归算法
     * 二叉树的中序遍历
     * @param root 二叉树的根
     * @return 遍历完成之后的二叉树节点值数组
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> ret = new ArrayList<>();
        ret.addAll(inorderTraversal2(root.left));
        ret.add(root.val);
        ret.addAll(inorderTraversal2(root.right));

        return ret;
    }

    /**
     * 迭代算法
     * 二叉树的后续遍历
     * @param root 二叉树的根节点
     * @return 遍历后的二叉树节点值数组
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            if (top.right == null || top.right == last) {
                stack.pop();
                ret.add(top.val);
                last = top;
            } else {
                cur = top.right;
            }
        }
        return ret;
    }

    /**
     * 递归写法
     * 二叉树的后序遍历
     * @param root 二叉树的根节点
     * @return 二叉树的节点值的数组
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> ret = new ArrayList<>();
        ret.addAll(postorderTraversal2(root.left));
        ret.addAll(postorderTraversal2(root.right));
        ret.add(root.val);

        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();

        System.out.println(preorderTraversal(root));
        System.out.println(preorderTraversal2(root));

        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversal2(root));


        System.out.println(postorderTraversal(root));
        System.out.println(postorderTraversal2(root));

    }
}
