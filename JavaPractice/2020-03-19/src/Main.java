import java.util.ArrayList;
import java.util.Stack;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Main {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
     * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();

        int row = matrix.length;
        while(row != 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                ret.add(matrix[0][i]);
            }

            matrix = revert(matrix);

            row = matrix.length;
        }
        return ret;
    }

    /**
     * 每次去掉矩阵第一行，将矩阵逆时针旋转九十度
     * @param matrix
     * @return
     */
    private int[][] revert(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] newMatrix = new int[col][row - 1];

        for (int j = col - 1; j >= 0; j--) {
            for (int i = 1; i < row; i++) {
                newMatrix[col - 1 - j][i - 1] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    /**
     * 两个栈实现队列
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (min.isEmpty()) {
            min.push(node);
        } else {
            min.push((min.peek()) > node ? node : min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
