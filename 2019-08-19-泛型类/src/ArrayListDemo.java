import java.util.ArrayList;
import java.util.List;

class Method {
    private List<List<Integer>> generate0 (int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> nums = new ArrayList<>();
            nums.add(1);
            for (int j = 0; j <= i - 2; j++) {
                List<Integer> preNums = list.get(i - 1);
                int p = preNums.get(j);
                int q = preNums.get(j + 1);
                int n = p + q;
                nums.add(n);
            }

            if (i != 0) {
                nums.add(1);
            }

            list.add(nums);
        }
            return list;
    }

    private List<List<Integer>> generate1 (int numRows) {
        List<List<Integer>> list;
        /**
         * outList 是一种引用,List 类型的接口引用
         * outList 逻辑上是一种线性表
         * 线性表的元素类型是 List</Integer>
         *      List 类型的引用接口
         *      元素类型是 Integer 类类型的引用
         *      Integer 是 int 的包装类
         */
        list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>(100));
        }

        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for (int i = 2; i < numRows; i++) {
            List<Integer> nums = list.get(i);
            nums.add(1);
            for (int j = 1; j < i; j++) {
                int num = list.get(i - 1).get(j - 1) +
                        list.get(i - 1).get(j);
                nums.add(num);
            }
            nums.add(1);
        }
        return list;
    }

    private List<List<Integer>> generate2 (int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= numRows; i++) {
            for (int j = 0; j < i; j++) {
                list.get(i).add(1);
            }
        }
        return list;
    }

    public void testMethod (Method m, int n) {
        System.out.println(m.generate0(n));
        System.out.println(m.generate1(n));
        System.out.println(m.generate2(n));
    }
}

public class ArrayListDemo {
    public static void main(String[] args) {
        Method method = new Method();
        method.testMethod(method, 6);
    }
}
