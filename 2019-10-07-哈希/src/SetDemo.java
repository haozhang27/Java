import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/07
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("java");
        set.add("he");
        set.add("e");
        System.out.println(set);
        System.out.println(set.contains("hello"));
        System.out.println(set.contains("oo"));

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
