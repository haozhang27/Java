import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/08
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("java");
        set.add("hello");
        set.add("SE");

        System.out.println(set);
        System.out.println(set.contains("hello"));
        System.out.println(set.contains("DS"));


        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (String s : set) {
            System.out.println(s);
        }
    }
}
