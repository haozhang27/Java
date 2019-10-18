/**
 * KPM 算法
 *
 * @author haozhang
 * @date 2019/10/18
 */
public class KPM {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        int h = haystack.length();
        int n = needle.length();

        if (h < n) {
            return -1;
        }


         // haystack 的下标
        int index1 = 0;

        // needle 的下标
        int index2 = 0;

        char[] array1 = haystack.toCharArray();
        char[] array2 = needle.toCharArray();


        // 获取 nexts 数组
        int[] nexts = getNext(array2);

        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] == array2[index2]) {
                index1++;
                index2++;
            } else if (nexts[index2] == -1) {
                index1++;
            } else {
                index2 = nexts[index2];
            }
        }

        return index2 == array2.length ? index1 - index2 : -1;
    }

    private int[] getNext(char[] str) {
        if(str.length == 1) {
            return new int[] {-1};
        }

        int[] nexts = new int[str.length];
        nexts[0] = -1;
        nexts[1] = 0;

        int cur = 0;
        int index = 2;
        while (index < str.length) {
            if (str[index - 1] == str[cur]) {
                nexts[index++] = ++cur;
            } else if (cur > 0) {
                cur = nexts[cur];
            } else {
                nexts[index++] = 0;
            }
        }
        return nexts;
    }
}
