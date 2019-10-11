
import java.util.Comparator;
import java.util.TreeMap;

class Person implements Comparable<Person> {
    public String name;

    public Person (String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}

class Contact {
    public String phone;
    public String address;

    public Contact(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }
}

class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/11
 */
public class TreeMapDemo1 {
    public static void main(String[] args) {
        TreeMap<Person, Contact> treeMap = new TreeMap<>(new PersonComparator());
        Person person = new Person("zhang");
        Contact contact = new Contact("111", "北大街");
        treeMap.put(person, contact);

        TreeMap<String, Integer> map1 = new TreeMap<>();


    }
}
