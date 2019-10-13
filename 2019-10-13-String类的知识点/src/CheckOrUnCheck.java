import java.io.IOException;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/13
 */
public class CheckOrUnCheck {
    public static void method1() {
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void method2() throws IOException {
        throw new IOException();
    }

    public static void method3() throws IOException {
        method2();
    }

    public static void tryResource() {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.nextInt();
        }
    }

    public static void methodUncheck() throws RuntimeException {
        throw new RuntimeException();
    }
}

