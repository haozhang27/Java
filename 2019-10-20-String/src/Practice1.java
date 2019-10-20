/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/20
 */
public class Practice1 {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }

        String[] arr = s.split(" ");
        while (arr.length >= 1) {
            if (!arr[arr.length - 1].equals(" ")) {
                return arr[arr.length - 1].toCharArray().length;
            }
        }
        return 0;
    }
}
