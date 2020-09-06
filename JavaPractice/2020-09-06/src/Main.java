import java.util.Scanner;

/**
 * 计算两个字符串的最大公共字串的长度，字符不区分大小写
 *
 * @author haozhang
 * @date 2020/09/06
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(getEqualsLen(s1, s2));
        }
    }

    public static int getEqualsLen(String s1, String s2) {
        String small = null;
        String big = null;
        if (s1.length() > s2.length()) {
            big = s1;
            small = s2;
        } else {
            big = s2;
            small = s1;
        }

        int max = 0;
        for (int i = 0; i < small.length(); i++) {
            for (int j = i; j < small.length() + 1; j++) {
                String s = small.substring(i, j);
                for (int k = 0; k < big.length(); k++) {
                    if (k + s.length() <= big.length()) {
                        String s3 = big.substring(k, k + s.length());
                        if (s3.equalsIgnoreCase(s)) {
                            max = Math.max(max, s.length());
                        }
                    }
                }
            }
        }

        return max;
    }
}
