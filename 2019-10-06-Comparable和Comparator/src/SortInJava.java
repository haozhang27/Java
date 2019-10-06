import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/06
 */
public class SortInJava {
    public static void main(String[] args) {
        Person[] people = new Person[10];
        Arrays.sort(people);
        Arrays.sort(people, new PersonRankComparator());

        List<Person> people1 = new ArrayList<>();
        people1.sort(new PersonRankComparator());
    }
}
