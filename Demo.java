import java.util.*;
/**
 * 对接口的简单了解
 *
 * @author haozhang
 * @date 2019/09/10
 */
public class Demo {
    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("j");
        list.add("a");
        list.add("v");
        list.add("a");
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));

        for (String s : list) {
            System.out.println(s);
        }

        list.remove("j");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        for (String s : list) {
            System.out.println(s);
        }

        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
