import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/23
 */
public class Practice1 {
    private final String[] s = new String[] {".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...",
            "-","..-","...-",".--","-..-","-.--","--.."};

    /**
     * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合
     * 返回我们可以获得所有词不同单词翻译的数量
     * @param words 要翻译的单词
     * @return 返回我们可以获得所有词不同单词翻译的数量
     */
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(s[(int)c - 97]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
