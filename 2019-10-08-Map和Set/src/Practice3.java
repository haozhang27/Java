import java.util.*;

/**
 * 子域名访问计数问题 力扣
 *
 * @author haozhang
 * @date 2019/10/08
 */
public class Practice3 {
    public List<String> subDoMainVisits(String[] array) {
        Map<String, Integer> count = new HashMap<>(16);
        for (String s : array) {
            String[] t = s.split(" ");
            int n = Integer.valueOf(t[0]);
            String domain = t[1];

            String[] u = domain.split("\\.");
            for (int i = 0; i < u.length; i++) {
                String[] sub = Arrays.copyOfRange(u, i, u.length);
                String d = String.join(".", sub);

                int oldCount = count.getOrDefault(d, 0);
                count.put(d, oldCount + n);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            String d = e.getKey();
            int n = e.getValue();

            result.add(n + " " + d);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> r = new Practice3().subDoMainVisits(s);
        System.out.println(r);

    }
}
