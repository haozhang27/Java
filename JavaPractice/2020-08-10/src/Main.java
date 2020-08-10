import java.util.*;

/**
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，
 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 0 3
 * 1 2
 * 3 4
 *
 * @author haozhang
 * @date 2020/08/10
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = Integer.parseInt(sc.nextLine());
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                String[] keyVal = sc.nextLine().split(" ");
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(keyVal[0]));
                list.add(Integer.parseInt(keyVal[1]));
                lists.add(list);
            }
            sortLists(lists);
        }
    }



    public static void sortLists(List<List<Integer>> lists) {
        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        Stack<Integer> stackKey = new Stack<>();
        Stack<Integer> stackVal = new Stack<>();
        stackKey.push(lists.get(0).get(0));
        stackVal.push(lists.get(0).get(1));
        for (int i = 1; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            if (!stackKey.isEmpty() && stackKey.peek().equals(list.get(0))) {
                stackVal.push(list.get(1));
            }

            if (!stackKey.isEmpty() && !stackKey.peek().equals(list.get(0))) {
                getMap(stackKey, stackVal);
                stackKey.push(list.get(0));
                stackVal.push(list.get(1));
            }

            if (i == lists.size() - 1) {
                getMap(stackKey, stackVal);
            }
        }
    }

    public static void getMap(Stack<Integer> stackKey, Stack<Integer> stackVal) {
        int val = 0;
        while (!stackVal.isEmpty()) {
            val += stackVal.pop();
        }

        int key = 0;
        while (!stackKey.isEmpty()) {
            key = stackKey.pop();
        }
        System.out.println(key + " " + val);
    }
}
