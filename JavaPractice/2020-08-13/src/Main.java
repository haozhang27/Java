import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理：
 *
 * 1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同
 * 的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 *
 * @author haozhang
 * @date 2020/08/13
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>(16);
        while (sc.hasNext()) {
            String fileName = sc.next();
            int lineNum = sc.nextInt();
            for (int i = fileName.length() - 1; i >= 0; i--) {
                if (fileName.charAt(i) == '\\') {
                    fileName = fileName.substring(i + 1);
                    break;
                }
            }

            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }
            String key = fileName + " " + lineNum;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        int count = 0;
        for (String s : map.keySet()) {
            count++;
            if (count > (map.size() - 8)) {
                System.out.println(s + " " + map.get(s));
            }
        }
    }
}
