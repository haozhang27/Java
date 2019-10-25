import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/25
 */
public class Practice3 {
    /**
     * 返回杨辉三角的第 rowIndex 行
     * @param rowIndex 要返回的行数
     * @return rowIndex 行的所有数据
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();

        if (rowIndex == 0) {
            List<Integer> ret = new ArrayList<>();
            ret.add(1);
            return ret;
        }

        list.add(new ArrayList<>());
        list.get(0).add(1);

        for (int num = 1; num <= rowIndex; num++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = list.get(num - 1);

            row.add(1);

            for (int j = 1; j < num; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }

            row.add(1);
            list.add(row);
        }

        return list.get(rowIndex);
    }
}
