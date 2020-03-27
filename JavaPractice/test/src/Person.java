import java.util.Objects;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/27
 */
public class Person {
    private String name;
    private int age;
    private int gender;

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Person person = (Person) obj;
        return name.equals(person.name) && age == person.age
                && gender == person.gender;
    }

    public static void main(String[] args) {
        MyHashMap<Person, Integer> map = new MyHashMap<>();
        Person p1 = new Person();
        p1.name = "p1";
        p1.age = 18;
        p1.gender = 1;

        Person p2 = new Person();
        p2.name = "p1";
        p2.age = 18;
        p2.gender = 1;

        map.put(p1, 111);
        //因为覆写了hashCode 和 equals，代码才能正确运行  否则返回null
        System.out.println(map.get(p2));
    }
}
