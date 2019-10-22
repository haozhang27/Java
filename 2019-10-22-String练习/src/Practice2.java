/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/22
 */
public class Practice2 {
    public String reverseWords(String s) {
       char[] arr = s.toCharArray();
       int left = 0;
       int i;
       for (i = 0; i < arr.length; i++) {
           if (arr[i] == ' ') {
               reverse(arr, left, i - 1);
               if (i + 1 < arr.length) {
                   left = i + 1;
               } else {
                   left = i;
               }
           }
       }

       if (left != arr.length) {
            reverse(arr, left, arr.length - 1);
       }

       return String.valueOf(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }


    public String reverseWords1(String s) {
        String[] sp = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sp.length; i++) {
            StringBuilder t = new StringBuilder();
            t.append(sp[i]);
            sb.append(t.reverse().toString()).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }

}
