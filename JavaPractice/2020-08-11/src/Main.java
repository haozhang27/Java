import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换
 * 行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 输入
 * abaca
 * 输出
 * 3
 *
 * @author haozhang
 * @date 2020/08/11
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(getCharCount(s));
        }
    }

    public static int getCharCount(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            set.add(c);
        }
        return set.size();
    }
}
