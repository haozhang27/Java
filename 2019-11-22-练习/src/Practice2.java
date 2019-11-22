import java.math.BigInteger;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/22
 */
public class Practice2 {
    public void sumOfNums(String s1, String s2) {
        BigInteger num1 = new BigInteger(s1);
        BigInteger num2 = new BigInteger(s2);
        System.out.println(num1.add(num2));
    }
}
