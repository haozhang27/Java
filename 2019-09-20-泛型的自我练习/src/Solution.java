import java.util.ArrayList;
import java.util.List;

/**
 * 用来测试根据 numRows 来输出杨辉三角中对应行的所有元素
 *
 * @author haozhang
 * @date 2019/08/20
 */
public class Solution {
    private List<List<Integer>> generate0 (int numRows) {
        List<List<Integer>> oneList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> twoList = new ArrayList<>();
            twoList.add(1);
            for (int j = 0; j <= i - 2 ; j++) {
                List<Integer> threeList = oneList.get(i - 1);
                int p = threeList.get(j);
                int q = threeList.get(j + 1);
                int n = p + q;
                twoList.add(n);
            }

            if (i != 0) {
                twoList.add(1);
            }

            oneList.add(twoList);
        }

        return oneList;
    }

    private List<List<Integer>> generate1 (int numsRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numsRows; i++) {
            list.add(new ArrayList<>(100));
        }

        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);

        for (int i = 2; i < numsRows; i++){
            List<Integer> nums = list.get(i);
            nums.add(1);
            for (int j = 1; j < i; j++) {
                int num = list.get(i - 1).get(j - 1)
                        + list.get(i - 1).get(j);
                nums.add(num);
            }
            nums.add(1);
        }
        return list;
    }

    private static void printPascalsTriangle(Solution s, int n) {
        System.out.println(s.generate0(5));
        System.out.println(s.generate1(5));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printPascalsTriangle(solution, 5);
    }
}
