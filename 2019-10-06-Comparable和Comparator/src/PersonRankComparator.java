import java.util.Comparator;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/06
 */
public class PersonRankComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.rank - o2.rank;
    }
}
