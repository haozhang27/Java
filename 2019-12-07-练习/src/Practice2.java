import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Practice2 {
    public void change() {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String ip = in.nextLine();
            String p = in.nextLine();
            System.out.println(IptoTen(ip));
            TentoIp(p);
        }
    }

    private void TentoIp(String p) {
        long temp = Long.parseLong(p);
        String ip = Long.toBinaryString(temp);
        StringBuilder sb = new StringBuilder();
        if(ip.length() < 32){
            for(int i = 0; i < (32-ip.length()); i++){
                sb.append(0);
            }
            sb.append(ip);
        }else if(ip.length() == 32){
            sb.append(ip);
        }
        for(int i = 0; i < sb.length()-8; i = i+8){
            System.out.print(Integer.parseInt(sb.substring(i, i+8),2) + ".");
        }
        System.out.println(Integer.parseInt(sb.substring(sb.length()-8, sb.length()), 2));
    }

    private long IptoTen(String ip) {
        String[] arr = ip.split("\\.");
        long n = Long.parseLong(arr[0]);
        for(int i = 1; i < arr.length; i++){
            n = n<<8;
            n = n + Long.parseLong(arr[i]);
        }
        return n;
    }
}
