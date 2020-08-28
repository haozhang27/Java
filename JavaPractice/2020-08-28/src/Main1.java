import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 有4个线程和1个公共的字符数组。
 * 线程1的功能就是向数组输出A，
 * 线程2的功能就是向字符输出B，
 * 线程3的功能就是向数组输出C，线程4的功能就是
 * 向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，
 * ABCD的个数由线程函数1的参数指定。
 *
 * @author haozhang
 * @date 2020/08/28
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExecutorService service = Executors.newSingleThreadExecutor();
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                service.execute(new Task("A"));
                service.execute(new Task("B"));
                service.execute(new Task("C"));
                service.execute(new Task("D"));
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
        service.shutdown();
    }
}


class Task implements Runnable {
    public String outPut = null;
    Task(String outPut) {
        this.outPut = outPut;
    }

    @Override
    public void run() {
        System.out.print(outPut);
    }
}

