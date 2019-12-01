
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 16, 18};
        practice1.sortNumbers(arr);
        System.out.println();
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);

        root.left = n1; root.right = n2;
        n1.left = n3; n1.right = n4;
        n2.left = null; n2.right = null;
        n3.left = n5; n3.right = null;
        n4.left = null; n4.right = null;
        n5.left = null; n5.right = null;
        System.out.println(practice2.isBalance(root));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
