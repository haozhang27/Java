import java.util.Arrays;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/07
 */
public class Main {
    private static void test1() {
        Practice1 practice1 = new Practice1();
        char[][] arr = new char[][] {{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(practice1.isValidSuDoKu(arr));
    }

    private static void test2() {
        Practice2 practice2 = new Practice2();
        int[] arr1 = new int[] {8, 0, 3};
        int[] arr2 = new int[] {0, 0};
        System.out.println(Arrays.toString(practice2.intersection(arr1, arr2)));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
