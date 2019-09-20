import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayListDemo {
    /**
     * 对 List 接口的体会
     * 构造的对象如果不初始化容量使用的是默认容量，初始化后使用的是初始化的容量
     * @param args 输出一些结果
     */
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>(100);

        Set<String> set = new HashSet<>();
        set.add("你好");
        set.add("中国");
        set.add("世界");

        List<String> list3 = new ArrayList<>(set);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }
}
