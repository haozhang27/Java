import java.util.Scanner;

/**
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其
 * 结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 *
 * @author haozhang
 * @date 2020/09/04
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int[][] arr1 = new int[x][y];
            for (int i = 0; i < x; i ++) {
                for (int j = 0; j < y; j++) {
                    arr1[i][j] = sc.nextInt();
                }
            }

            int[][] arr2 = new int[y][z];
            for (int i = 0; i < y; i ++) {
                for (int j = 0; j < z; j++) {
                    arr2[i][j] = sc.nextInt();
                }
            }

            int[][] productMatrix = productMatrix(arr1, arr2);
            for (int i = 0; i < productMatrix.length; i++) {
                for (int j = 0; j < productMatrix[0].length; j++) {
                    System.out.print(productMatrix[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] productMatrix(int[][] arr1, int[][] arr2) {
        int[][] ret = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                ret[i][j] = getProduct(arr1, i, arr2, j);
            }
        }

        return ret;
    }

    public static int getProduct(int[][] arr1, int row, int[][] arr2, int col) {
        int product = 0;
        for (int i = 0, j = 0; i < arr1[0].length && j < arr2.length; i++, j++) {
            int num = arr1[row][i] * arr2[j][col];
            product += num;
        }
        return product;
    }
}
