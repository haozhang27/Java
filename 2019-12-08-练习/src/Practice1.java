/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/08
 */
public class Practice1 {
    /**
     * 守形数是这样一种整数，它的平方的低位部分等于它本身。 比如25的平方是625，
     * 低位部分是25，因此25是一个守形数。 编一个程序，判断N是否为守形数。
     * @param n 给定的整数
     * @return true表示是守形数；false表示不是
     */
    public boolean isKeepTypeNumber(int n) {
        int num = n * n;
        String str1 = String.valueOf(n);
        String str2 = String.valueOf(num);
        if (!str1.equals(str2.substring(str2.length() - str1.length() ,str2.length()))) {
            return false;
        }
        return true;
    }
}
