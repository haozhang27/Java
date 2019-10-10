
import java.util.Comparator;
import java.util.TreeMap;

/*
class Person {
    public String name;

    Person (String name) {
        this.name = name;
    }
}
*/

class Person implements Comparable<Person> {
    public String name;

    Person (String name) {
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

    Contact (String phone, String address) {
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
public class TreeMapDemo {
    public static void main(String[] args) {
        //TreeMap<Person, Contact> map = new TreeMap<>(new PersonComparator());
        TreeMap<Person, Contact> map = new TreeMap<>();
        Person person = new Person("zhang");
        Contact contact = new Contact("001", "北大街");
        map.put(person, contact);

        TreeMap<String, Integer> map1 = new TreeMap<>();
        TreeMap<String, Integer> map2 = new TreeMap<>();
    }
}
