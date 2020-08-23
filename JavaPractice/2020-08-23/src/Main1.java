import java.util.Arrays;
import java.util.Scanner;

/**
 * ly上课时使用字母数字图片教小朋友们学习英语单词，每次都需
 * 要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
 *
 * @author haozhang
 * @date 2020/08/23
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }
}
