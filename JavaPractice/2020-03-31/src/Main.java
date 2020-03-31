/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/31
 */
public class Main {
    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
     * 数值为0或者字符串不是一个合法的数值则返回0
     * @param str
     * @return
     */
    public int strToInt(String str) {
        //用ret来保存最终结果
        int ret = 0;

        //用来记录转换到第几位了
        int count = 0;
        //如果str是空字符串
        if (str.length() == 0) {
            return ret;
        }


        //这里判断那些超出int所能表示范围的数
        if (str.length() == 10) {
            //如果str是 2147483648 2147483649
            if (Long.parseLong(str) > Integer.MAX_VALUE) {
                return 0;
            }
        } else if (str.length() == 11) {
            //如果str是 +2147483648 +2147483649
            if (Long.parseLong(str) > Integer.MAX_VALUE) {
                return 0;
            }

            //如果str是 -2147483649
            if (Long.parseLong(str) < Integer.MIN_VALUE) {
                return 0;
            }
        } else if (str.length() > 11) {
            return 0;
        }


        //如果这个数是负数  例如 -123 = -3*10^0 - 2*10^1 - 1*10^2
        if (str.charAt(0) == '-') {
            for (int i = str.length() - 1; i >= 0; i--) {
                char c = str.charAt(i);
                //判断str是不是合法的数值
                if (c < '0' || c > '9') {
                    if (c != '+' && c != '-') {
                        return 0;
                    }
                } else {
                    ret -= Integer.parseInt(str.substring(i, i + 1))
                            * Math.pow(10, count);
                    count++;
                }
            }
        } else {
            for (int i = str.length() - 1; i >= 0; i--) {
                char c = str.charAt(i);
                //判断str是不是合法的数值
                if (c < '0' || c > '9') {
                    if (c != '+' && c != '-') {
                        return 0;
                    }
                } else {
                    ret += Integer.parseInt(str.substring(i, i + 1))
                            * Math.pow(10, count);
                    count++;
                }
            }
        }
        return ret;
    }
}
