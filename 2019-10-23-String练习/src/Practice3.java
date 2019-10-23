/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/23
 */
public class Practice3 {
    /**
     * 将字符串中的大写字母转换成小写字母
     * @param str 要操作的字符串
     * @return 转化完成之后的字符串
     */
    public String toLowerCase(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }

            arr[i] = c;
        }
        return new String(arr);
    }
}
