import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/02
 */
public class Practice1 {
    /**
     *
     * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
     * 学生ID编号从1编到N。
     * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
     * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
     * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
     */
    public void scoreOfBiggest() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                String s = sc.next();
                int ret = 0;
                int A = sc.nextInt();
                int B = sc.nextInt();
                int begin = Math.min(A, B) - 1;
                int end = Math.max(A, B);
                if (s.equals("Q")) {
                    for (int j = begin; j < end; j++) {
                        ret = Math.max(ret, arr[j]);
                    }
                    System.out.println(ret);
                } else if (s.equals("U")) {
                    arr[A-1] = B;
                }
            }
        }
    }
}
