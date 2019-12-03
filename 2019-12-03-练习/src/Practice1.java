import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/03
 */
public class Practice1 {
    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * @param preorder 先序遍历顺序
     * @param inorder 中序遍历顺序
     * @return 创建好的二叉树的根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        int leftCount = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                leftCount = i;
                break;
            }
        }

        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, 1 + leftCount);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, leftCount);
        TreeNode left = buildTree(leftPreOrder, leftInOrder);
        root.left = left;

        int[] rightPreOrder = Arrays.copyOfRange(preorder, leftCount + 1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, leftCount + 1, inorder.length);
        TreeNode right = buildTree(rightPreOrder, rightInOrder);
        root.right = right;

        return root;
    }
}
