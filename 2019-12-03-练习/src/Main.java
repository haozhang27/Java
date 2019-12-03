
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/03
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] preorder = new int[] {3, 9, 20, 15, 7};
        int[] inorder = new int[] {9, 3, 15, 20, 7};
        TreeNode root = practice1.buildTree(preorder, inorder);
        Practice3 practice3 = new Practice3();
        System.out.println(practice3.preorderTraversal(root));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] inorder = new int[] {3, 9, 15, 20, 7};
        int[] postorder = new int[] {9, 15, 7, 20, 3};
        TreeNode root = practice2.buildTree(inorder, postorder);
        Practice3 practice3 = new Practice3();
        System.out.println(practice3.preorderTraversal(root));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
