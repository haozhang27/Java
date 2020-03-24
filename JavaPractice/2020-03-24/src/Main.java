/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/24
 */
public class Main {
    public int numberOf1Between1AndN_Solution(int n) {
        int ret = 0;
        for (int i = 1; i < n + 1; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    ret++;
                }
            }
        }

        return ret;
    }

    public String printMinNumber(int [] numbers) {
        StringBuilder sb = new StringBuilder();
        String str1 = null;
        String str2 = null;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                str1 = String.valueOf(numbers[j]);
                str2 = String.valueOf(numbers[j + 1]);
                if ((str1 + str2).compareTo(str2 + str1) > 0) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }
}
