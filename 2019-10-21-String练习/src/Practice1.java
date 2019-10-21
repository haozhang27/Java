/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/21
 */
public class Practice1 {
    /**
     * 输入：
     * ["a","a","b","b","c","c","c"]
     *
     * 输出：
     * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
     *
     * @param chars 要压缩的数组
     * @return 压缩后的数组元素个数
     */
    public int compress(char[] chars) {
       int left = 0;
       int size = 0;

       for (int right = 0; right <= chars.length; right++) {
           if (right == chars.length || chars[right] != chars[left]) {
               chars[size] = chars[left];
               size++;

               if (right - left > 1) {
                   for (char c : String.valueOf(right - left).toCharArray()) {
                       chars[size] = c;
                       size++;
                   }
               }
               left = right;
           }
       }
       return size;
    }
}
