
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/23
 */
public class Trees {
    private static Node buildTree () {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');
        Node h = new Node('h');

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        d.left = null; d.right = null;
        e.left = null; e.right = h;
        c.left = f; c.right = g;
        f.left = null; f.right = null;
        g.left = null; g.right = null;

        return a;
    }


    public static void preOrderTraversal (Node root) {
        if (root == null) {
            return;
        }
        //根 + 左子树 + 右子树
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal (Node root) {
        if (root == null) {
            return;
        }
       inOrderTraversal(root.left);
       System.out.println(root.value);
       inOrderTraversal(root.right);
    }

    public static void postOrderTraversal (Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }

    public static int count;
    public static void calcCount (Node root) {
        if (root == null) {
            return;
        }

        count++;
        calcCount(root.left);
        calcCount(root.right);
    }

    public static int calcCount2 (Node root) {
        if (root == null) {
            return 0;
        }

        int left = calcCount2(root.left);
        int right = calcCount2(root.right);
        int count = left + right + 1;
        return count;
    }

    public static int leafCount;
    public static void calcLeafCount1 (Node root) {
        if (root == null) {
            return;
        }

        calcLeafCount1(root.left);
        if (root.left == null && root.right == null) {
            leafCount++;
        }
        calcLeafCount1(root.right);
    }
    public static int calcLeafCount2 (Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = calcLeafCount2(root.left);
        int right = calcLeafCount2(root.right);
        int leafCount = left + right;
        return leafCount;
    }

    public static int calcHeight (Node root) {
        if (root == null) {
            return 0;
        }

        int left = calcHeight(root.left);
        int right = calcHeight(root.right);
        int height = Math.max(left, right) + 1;

        return height;
    }

    public static int calcKLevel (Node root, int k) {
        if (root == null) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        int left = calcKLevel(root, k - 1);
        int right = calcKLevel(root, k - 1);
        int kCount = left + right;
        return  kCount;
    }

    public static Node search (Node root, char val) {
        if (root == null) {
            return null;
        }

        if (root.value == val) {
            return root;
        }

        Node left = search(root.left, val);
        if (left != null) {
            return left;
        }

        Node right = search(root.right, val);
        if (right != null) {
            return right;
        }

        return null;
    }

    public static boolean search2 (Node root, int val) {
        if (root == null) {
            return false;
        }

        if (root.value == val) {
            return true;
        }

        if(search2(root.left, val)) {
            return true;
        }

        return search2(root.right, val);
    }

    public static boolean isMirror (Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.value == q.value &&
                isMirror(p.left, q.right) &&
                isMirror(p.right, q.left);
    }

    public static Node buildTree1 (List<Character> preOrder, List<Character> inOrder) {
        if (preOrder.size() == 0) {
            return null;
        }

        char rootValue = preOrder.get(0);
        Node root = new Node(rootValue);

        int leftCount = inOrder.indexOf(rootValue);
        List<Character> leftPreOrder = preOrder.subList(1, 1 + leftCount);
        List<Character> leftInOrder = inOrder.subList(0, leftCount);
        Node left = buildTree1(leftPreOrder, leftInOrder);
        root.left = left;

        List<Character> rightPreOrder = preOrder.subList(leftCount + 1, preOrder.size());
        List<Character> rightInOrder = inOrder.subList(leftCount + 1, inOrder.size());
        Node right = buildTree1(rightPreOrder, rightInOrder);
        root.right = right;

        return root;
    }

    public static Node buildTree2 (List<Character> inOrder, List<Character> postOrder) {
        if (postOrder.size() == 0) {
            return null;
        }

        char rootValue = postOrder.get(postOrder.size() - 1);
        Node root = new Node(rootValue);

        int leftCount = inOrder.indexOf(rootValue);
        List<Character> inOrderLeft = inOrder.subList(0, leftCount + 1);
        List<Character> postOrderLeft = postOrder.subList(0, leftCount);
        Node left = buildTree2(inOrderLeft, postOrderLeft);
        root.left = left;

        List<Character> inOrderRight = inOrder.subList(leftCount + 1, inOrder.size());
        List<Character> postOrderRight = postOrder.subList(leftCount, postOrder.size() - 1);
        Node right = buildTree2(inOrderRight, postOrderRight);
        root.right = right;

        return root;
    }



    public Node buildTree(char[] inOrder, char[] postOrder) {
        if (postOrder.length == 0) {
            return null;
        }

        char rootValue = postOrder[postOrder.length - 1];
        Node root = new Node(rootValue);

        int leftCount = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                leftCount = i;
                break;
            }
        }

        char[] inorderLeft = Arrays.copyOfRange(inOrder, 0, leftCount);
        char[] postOrderLeft = Arrays.copyOfRange(postOrder, 0, leftCount);
        Node left = buildTree(inorderLeft, postOrderLeft);
        root.left = left;

        char[] inOrderRight = Arrays.copyOfRange(inOrder, leftCount + 1, inOrder.length);
        char[] postOrderRight = Arrays.copyOfRange(postOrder, leftCount, postOrder.length - 1);
        Node right = buildTree(inOrderRight, postOrderRight);
        root.right = right;

        return root;

    }

    public static void main(String[] args) {
        /**
        Node root = buildTree();
        preOrderTraversal(root);
        System.out.println("=======");
        inOrderTraversal(root);
        System.out.println("=======");
        postOrderTraversal(root);

        calcCount(root);
        System.out.println(count);
        System.out.println(calcCount2(root));

        calcLeafCount1(root);
        System.out.println(leafCount);
        System.out.println(calcLeafCount2(root));

        System.out.println(calcHeight(root));

        System.out.println(calcKLevel(root, 3));

        System.out.println(search(root, 'd'));
        System.out.println(search2(root,'d'));

        List<Character> preOrder = Arrays.asList('a', 'b', 'c', 'd', 'e');
        List<Character> inOrder = Arrays.asList('b', 'a', 'd', 'c', 'e');
        List<Character> postOrder = Arrays.asList('b', 'd', 'e', 'c', 'a');
        Node root1 = buildTree1(preOrder, inOrder);
        System.out.println("====");

        Node root2 = buildTree2(inOrder, postOrder);
        System.out.println("====");
         */


    }
}
