import java.util.Random;

class MyArrayList {
    private int[] array;
    private int size;

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("下标越界");
        }

        return array[index];
    }
}

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/13
 */
public class ExceptionDemo {
    private static void method1() {
        MyArrayList list = new MyArrayList();

        try {
            list.get(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int method2() {
        MyArrayList list = new MyArrayList();
        int n = 100;
        try {
            list.get(0);
            System.out.println(n);
            return n;
        } finally {
            n = 10;
            System.out.println(n);
        }
    }


    static Random random = new Random();
    public static void a() {
        if (random.nextInt(5) == 0) {
            throw new RuntimeException("来自 a");
        }
    }

    public static void b() {
        a();
        if (random.nextInt(6) == 1) {
            throw new RuntimeException("来自 b");
       }
    }

    public static void c() {
        b();
        if (random.nextInt(6) == 2) {
            throw new RuntimeException("来自 c");
        }
    }

    public static void d() {
        c();
        if (random.nextInt(6) == 3) {
            throw new RuntimeException("来自 d");
        }
    }

    public static void e() {
        d();
        if (random.nextInt(6) == 4) {
            throw new RuntimeException("来自 e");
        }
    }


    public static void main(String[] args) {
        try {
            e();
            System.out.println("很幸运");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println("======");
    }
}
