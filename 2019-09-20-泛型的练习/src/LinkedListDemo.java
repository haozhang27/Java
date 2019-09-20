import java.util.LinkedList;
import java.util.Random;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/08/20
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.push("C");
        list.push("Java SE");
        list.push("DS");
        System.out.println(list);

        list.addLast("C");
        list.addLast("Java SE");
        list.addLast("DS");
        System.out.println(list);

        System.out.println(list.get(2));
        System.out.println(list.poll());
        System.out.println(list.pollFirst());
        System.out.println(list.peekLast());
        System.out.println(list.size());

        Random random = new Random(20190820);
        System.out.println(random.nextInt(52));
        System.out.println(random.nextInt(52));
    }
}
