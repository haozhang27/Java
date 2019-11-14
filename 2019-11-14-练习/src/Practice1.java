import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/14
 */
public class Practice1 {
    /**
     * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至
     * 开头继续进行，求最后一个被删掉的数的原始下标位置
     * @param N 给定的 n
     * @return 最后一个删除的数的下标
     */
    public int indexOfLastRemove(int N) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }

        int i = 0;
        while (list.size() > 1) {
            i = (i + 2) % list.size();
            list.remove(i);
        }

        return list.get(0);
    }

    public int indexOfRemoveLast(int N) {
        int num = 0;
        for (int i = 2; i <= N; i++) {
            num = (num + 3) % i;
        }

        return num;
    }

}
