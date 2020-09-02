import java.util.Scanner;

/**
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G
 * 和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。
 * 因为高的GC-Ratio可能是基因的起始点。
 *
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 *
 * @author haozhang
 * @date 2020/09/02
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        int ret = 0;
        char[] retChar = new char[n];

        for (int i = 0; i < str.length() - n; i++) {
            int count = 0;
            char[] arr = new char[n];
            int c = 0;
            for (int j = i; j < n + i; j++) {
                if (str.charAt(j) == 'C' || str.charAt(j) == 'G') {
                    count++;
                }
                arr[c++] = str.charAt(j);
            }


            if (count > ret) {
                for (int k = 0; k < arr.length; k++) {
                    retChar[k] = arr[k];
                }
            }
            ret = Math.max(ret, count);
        }

        if (str.length() == n) {
            System.out.println(str);
        } else {
            for (int i = 0; i < retChar.length; i++) {
                System.out.print(retChar[i]);
            }
        }
    }
}
