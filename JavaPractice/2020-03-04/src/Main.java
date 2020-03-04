/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/03/04
 */
public class Main {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param target 要查找的数
     * @param arr 查找的数组
     * @return true 表示target在arr中；false表示不在
     */
    public static boolean find(int target, int [][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int findRow = 0;
        int findCol = col - 1;
        while (findCol >= 0 && findRow < row) {
            int val = arr[findRow][findCol];
            if (val == target) {
                return true;
            } else if (val > target) {
                findCol--;
            } else {
                findRow++;
            }
        }
        return false;
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str 传入的字符串
     * @return 转换后的字符串
     */
    public static String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1, 2, 3},
                                   {4, 5, 6},
                                   {7, 8, 9}};
        int target = 5;
        System.out.println(find(target, arr));

        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(str));

    }
}
