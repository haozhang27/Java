import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;


public class Main {
    private static void swap(ArrayList<PokeCard> cards, int i, int j) {
        PokeCard temp1 = cards.get(i);
        PokeCard temp2 = cards.get(j);
        cards.set(i, temp2);
        cards.set(j, temp1);
    }

    public static void main(String[] args) {
        ArrayList<PokeCard> cards = new ArrayList<>(52);
        String[] colors = {"♥", "♦", "♣", "♠"};

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                PokeCard card = new PokeCard(j, colors[i]);
                cards.add(card);
            }
        }

        Random random = new Random(20190820);
        for (int i = 51; i > 0; i--) {
            int j = random.nextInt(i);
            swap(cards, i, j);
        }


        ArrayList<PokeCard> A = new ArrayList<>();
        ArrayList<PokeCard> B = new ArrayList<>();
        ArrayList<PokeCard> C = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; j++) {
                A.add(cards.get(j));
                cards.remove(j);

                B.add(cards.get(j + 1));
                cards.remove(j + 1);

                C.add(cards.get(j + 2));
                cards.remove(j + 2);
            }
        }

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);


        PokeCard heartA = new PokeCard(1, "♥");
        for (PokeCard card : A) {
            if (A.contains(heartA)) {
                System.out.println("包含");
                break;
            } else {
                System.out.println("不包含");
                break;
            }
        }

        for(int i = 0; i < 5; i++) {
            PokeCard o = A.get(i);
            PokeCard c = new PokeCard(1, "♥");
            if (A.equals(c)) {
                A.remove(c);
            }
        }

        System.out.println(A);
        //迭代器
        Iterator<PokeCard> it1 = A.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        System.out.println("============");
        ListIterator<PokeCard> it2 = A.listIterator();
        System.out.println(it2.next());
        System.out.println(it2.next());
        System.out.println(it2.previous());



    }
}
