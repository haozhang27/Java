import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/03
 */
public class Practice2 {
    /**
     * 根据 二叉树中序和后序创建二叉树
     * @param inorder 中序顺序
     * @param postorder 后续顺序
     * @return 创建后树的根节点
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }

        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);

        int leftCount = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                leftCount = i;
            }
        }


        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, leftCount);
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, leftCount);
        TreeNode left = buildTree(inorderLeft, postorderLeft);
        root.left = left;


        int[] inorderRight = Arrays.copyOfRange(inorder, leftCount + 1, inorder.length);
        int[] postorderRight = Arrays.copyOfRange(postorder, leftCount, postorder.length - 1);
        TreeNode right = buildTree(inorderRight, postorderRight);
        root.right = right;


        return root;

    }
}
