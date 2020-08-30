import java.math.BigInteger;
import java.util.Scanner;

/**
 * 大数相加
 *
 * @author haozhang
 * @date 2020/08/30
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String a=in.next();
            String b=in.next();
            BigInteger c=new BigInteger(a);
            BigInteger d=new BigInteger(b);
            System.out.println(c.add(d));
        }
    }
}
