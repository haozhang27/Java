/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/23
 */
public class Practice2 {
    public String countOfMin(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                sb.append(i);
                arr[i]--;
                break;
            }
        }

        while (arr[0] != 0) {
            sb.append('0');
            arr[0]--;
        }

        for (int i = 1; i < arr.length; i++) {
            while (arr[i] != 0) {
                sb.append(i);
                arr[i]--;
            }
        }

        return sb.toString();
    }
}
