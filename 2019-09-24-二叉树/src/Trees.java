import java.util.*;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/24
 */
public class Trees {
    static boolean ans = true;
    private static int height (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            ans = false;
        }

        return Math.max(left, right) + 1;
    }

    public static boolean isBalanced (TreeNode root) {
        height(root);
        return ans;
    }

    public static void levelOrderTraversal (TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode front = queue.poll();
            System.out.println(front.val);

            if (front.left != null) {
                queue.add(front.left);
            }

            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }


    private static class Element {
        TreeNode node;
        int level;
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultResult = new ArrayList<>();
        if (root == null) {
            return resultResult;
        }

        Queue<Element> queue = new LinkedList<>();
        Element e = new Element();
        e.node = root;
        e.level = 0;
        queue.add(e);

        while(!queue.isEmpty()) {
            Element front = queue.poll();

            if (front.level == resultResult.size()) {
                resultResult.add(new ArrayList<>());
            }

            resultResult.get(front.level).add(front.node.val);


            if (front.node.left != null) {
                Element l = new Element();
                l.node = front.node.left;
                l.level = front.level + 1;
                queue.add(l);
            }

            if (front.node.right != null) {
                Element r = new Element();
                r.node = front.node.right;
                r.level = front.level + 1;
                queue.add(r);
            }
        }

        return resultResult;
    }

    /**
     * 判断一棵树是否为完全二叉树
     * 思路：层序遍历二叉树，直到遇到空在进行判断
     * @param root 树的根
     * @return true 表示是完全二叉树， false 表示不是
     */
    public static boolean isCompleteTree (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            TreeNode front = queue.poll();
            if (front == null) {
                break;
            }

            queue.add(front.left);
            queue.add(front.right);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                return false;
            }
        }

        return true;
    }


    public static List<Integer> preOrderNoRecursion(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                retList.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            cur = top.right;
        }
        return retList;
    }

    public static List<Integer> inOrderNoRecursion(TreeNode root) {
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

    public static List<Integer> postOrderNoRecursion(TreeNode root) {
        List<Integer> retList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            if (top.right == null || top.right == last) {
                stack.pop();
                retList.add(top.val);
                last = top;
            } else {
                cur = top.right;
            }
        }
        return retList;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode();
        root.left.val = 2;

        root.right = new TreeNode();
        root.right.val = 3;

        root.left.left = new TreeNode();
        root.left.left.val = 4;

        System.out.println(isBalanced(root));

        levelOrderTraversal(root);

        System.out.println(levelOrder(root));

        System.out.println(isCompleteTree(root));

        System.out.println(preOrderNoRecursion(root));
        System.out.println(inOrderNoRecursion(root));
        System.out.println(postOrderNoRecursion(root));
    }
}
