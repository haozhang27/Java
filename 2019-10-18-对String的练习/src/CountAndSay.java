/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/18
 */
public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        n--;

        while (n > 0) {
            StringBuilder sbTemp = new StringBuilder();
            for (int i = 0, len = sb.length(); i < len; i++) {
                int j = i;

                int count = 0;

                while (j < len && (sb.charAt(j) == sb.charAt(i))) {
                    j++;
                    count++;
                }

                sbTemp.append(count).append(sb.charAt(i));

                i = j - 1;
            }
            n--;

            sb = sbTemp;
        }
        return sb.toString();
    }
}
