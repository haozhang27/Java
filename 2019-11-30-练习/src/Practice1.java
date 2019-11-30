import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/30
 */
public class Practice1 {
    /**
     * 给定两个字符串  判断 str1 中是否包含全部的 str2；
     *  如果包含，输出 "Yes"和str1中其他字符的个数
     *  如果不包含，输出 "No" 和str1没有str2中字符的个数
     * @param str1 字符串1
     * @param str2 字符串2
     * @return "Yes " 表示str1中包含 str2； "No" 表示不包含
     */
    public String isBuyGems(String str1, String str2) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < str2.length(); i++) {
            Object o = str2.charAt(i);
            list.add(o);
        }

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            Object o = c;
            if (list.contains(o)) {
                list.remove(o);
            }
        }

        StringBuffer sb = new StringBuffer();
        String ret;
        if (!list.isEmpty()) {
            sb.append("No ");
            sb.append(list.size());
            ret = sb.toString();
        } else {
            sb.append("Yes ");
            sb.append(str1.length() - str2.length());
            ret = sb.toString();
        }

        return ret;
    }
}
