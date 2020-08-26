import java.util.Scanner;

/**
 * 子网掩码可以判断两台主机是否中同一子网中。
 *
 * @author haozhang
 * @date 2020/08/26
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String mask = sc.nextLine();
            String ip1 = sc.nextLine();
            String ip2 = sc.nextLine();
            System.out.println(getRet(mask, ip1, ip2));
        }
    }

    public static int getRet(String mask, String ip1, String ip2) {
        String maskBinary = getBinary(mask);
        String ip1Binary = getBinary(ip1);
        String ip2Binary = getBinary(ip2);
        if (ip1Binary.length() != 32 || ip2Binary.length() != 32 || maskBinary.length() != 32) {
            return 1;
        }

        StringBuilder sbIp1 = maskAndIp(maskBinary, ip1Binary);
        StringBuilder sbIp2 = maskAndIp(maskBinary, ip2Binary);


        if (sbIp1.toString().equals(sbIp2.toString())) {
            return 0;
        }

        return 2;
    }

    public static StringBuilder maskAndIp(String maskBinary, String ipBinary) {
        StringBuilder sbIp = new StringBuilder();
        for (int i = 0; i < maskBinary.length(); i++) {
            if (maskBinary.charAt(i) == '1' && ipBinary.charAt(i) == '1') {
                sbIp.append(1);
            } else {
                sbIp.append(0);
            }
        }
        return sbIp;
    }

    public static String getBinary(String s) {
        String[] arr = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            String binary = Integer.toBinaryString(num);
            if (binary.length() < 8) {
                for (int j = 0; j < 8 - binary.length(); j++) {
                    sb.append(0);
                }
            }
            sb.append(binary);
        }
        return sb.toString();
    }
}
