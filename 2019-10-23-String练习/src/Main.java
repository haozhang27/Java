/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/23
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        String[] words = new String[] {"gin", "zen", "gig", "msg"};
        System.out.println(practice1.uniqueMorseRepresentations(words));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();

        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);

        root.left = n1; root.right = n2;
        n1.left = null; n1.right = n3;
        n2.left = null; n2.right = null;
        n3.left = null; n3.right = null;

        System.out.println(practice2.tree2str(root));
    }

    private static void test3() {
        Practice3 practice3 = new Practice3();
        String str = "Hello";
        System.out.println(practice3.toLowerCase(str));
    }

    private static void test4() {
        Practice4 practice4 = new Practice4();
        String word1 = "hello";
        String word2 = "look";
        System.out.println(practice4.minDistance(word1, word2));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
