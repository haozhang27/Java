public class Main {
    private static void testList (List list) {
        System.out.println(list.size());
        System.out.println(list.isEmpty());

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list);



        list.set(1, 200);
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        list.set(1, 200);
        System.out.println(list);


    }

    public static void main (String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        MyLinkedList myLinkedList = new MyLinkedList();
        testList(myArrayList);
        System.out.println("===============");
        testList(myLinkedList);
    }

}
