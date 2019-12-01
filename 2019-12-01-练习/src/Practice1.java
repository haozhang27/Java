/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Practice1 {
    /**
     * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
     * A1 = 能被5整除的数字中所有偶数的和；
     * A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
     * A3 = 被5除后余2的数字的个数；
     * A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
     * A5 = 被5除后余4的数字中最大数字。
     * @param arr 给定的数组
     */
    public void sortNumbers(int[] arr) {
        int A1 = 0;
        int A2 = 0;
        int A3 = 0;
        double A4 = 0.0;
        int A5 = 0;
        int count2 = 0;
        int count4 = 0;

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            if (n % 5 == 0 && n % 2 == 0) {
                A1 += n;
            }

            if (n % 5 == 1) {
                if (count2 % 2 == 0) {
                    A2 += n;
                } else {
                    A2 += -n;
                }
                count2++;
            }

            if (n % 5 == 2) {
                A3++;
            }

            if(n % 5 == 3){
                A4 += n;
                count4++;
            }

            if (n % 5 == 4) {
                A5 = Math.max(A5, n);
            }
        }

        if (A1 != 0) {
            System.out.print(A1 + " ");
        } else {
            System.out.print("N" + " ");
        }

        if (count2 != 0) {
            System.out.print(A2 + " ");
        } else {
            System.out.print("N" + " ");
        }

        if (A3 != 0) {
            System.out.print(A3 + " ");
        } else {
            System.out.print("N" + " ");
        }

        if (A4 != 0) {
            System.out.printf("%.1f ",1.0 * A4 / count4);
        } else {
            System.out.print("N" + " ");
        }

        if (A5 != 0) {
            System.out.print(A5);
        } else {
            System.out.print("N");
        }
    }
}
