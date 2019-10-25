import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/25
 */
public class Practice2 {
    /**
     * 给出一个行数，返回杨辉三角的前 numRows 行
     * @param numRows 要返回的行数
     * @return 前 numRows 行，每行所对应的数据
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();

        if (numRows == 0) {
            return ret;
        }

        ret.add(new ArrayList<>());
        ret.get(0).add(1);

        for (int num = 1; num < numRows; num++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = ret.get(num - 1);

            row.add(1);

            for (int j = 1; j < num; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }

            row.add(1);
            ret.add(row);
        }
        return ret;
    }
}
