
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，
 * 求这棵树的高度输入描述:输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为
 * 0到n-1）组成，下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表
 * 示子节点的编号
 * 输出描述:输出树的高度，为一个整数
 * 示例1
 * 输入5   0 1  0 2  1 3  1 4
 * 输出3
 *
 *
 * @author haozhang
 * @date 2020/04/13
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            Map<Integer, Integer> tree = new HashMap<>(16);
            Map<Integer, Integer> childHigh = new HashMap<>(16);

            tree.put(0, 0);
            childHigh.put(0, 1);

            int high = 0;
            int max = 1;

            for (int i = 0; i < num - 1; i++) {
                int father = sc.nextInt();
                int son = sc.nextInt();

                //树里面不包含父节点
                if (!tree.containsKey(father)) {
                    continue;
                }

                //父节点的儿子已满
                if (tree.get(father) >= 2) {
                    continue;
                }

                //父亲的孩子树+1
                tree.put(father, tree.get(father) + 1);

                //孩子变另一个父亲
                tree.put(son, 0);

                childHigh.put(son, childHigh.get(father) + 1);
                high = childHigh.get(son);

                if (max < high) {
                    max = high;
                }
            }
            System.out.println(high);
        }
    }




























}
