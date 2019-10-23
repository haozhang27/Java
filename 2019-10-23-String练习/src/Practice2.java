
/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/23
 */
public class Practice2 {

    StringBuilder sb = new StringBuilder();

    /**
     *
     * 将二叉树转换为仅由括号和数字组成的字符串
     * 空节点则用一对空括号 "()" 表示。
     * 而且省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        adds(t);

        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private void adds(TreeNode t) {
        if (t == null) {
            return;
        }

        sb.append('(');
        sb.append(t.val);

        if (t.left == null && t.right != null) {
            sb.append("()");
        }

        adds(t.left);
        adds(t.right);

        sb.append(')');
    }
}
