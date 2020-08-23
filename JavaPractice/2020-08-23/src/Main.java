import java.util.Scanner;

/**
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 *
 * @author haozhang
 * @date 2020/08/23
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(ipToNum(s));
            String s1 = sc.nextLine();
            System.out.println(numToIp(s1));
        }
    }

    public static String ipToNum(String s) {
        String[] arr = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String s1 = Long.toBinaryString(Long.parseLong(arr[i]));
            sb.append(getStr(s1));
        }
        return String.valueOf(Long.parseLong(sb.toString(), 2));
    }


    public static String numToIp(String s) {
        String s1 = Long.toBinaryString(Long.parseLong(s));
        StringBuilder sb = new StringBuilder();
        int num = s1.length() % 8;
        if (num > 0) {
            sb.append(Long.parseLong(s1.substring(0, num), 2));
            sb.append(".");
        }

        while (num + 8 <= s1.length()) {
            sb.append(Long.parseLong(s1.substring(num, num + 8), 2));
            sb.append(".");
            num += 8;
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static String getStr(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() < 8) {
            for (int i = 0; i < 8 - s.length(); i++) {
                sb.append("0");
            }
        }
        sb.append(s);
        return sb.toString();
    }
}
