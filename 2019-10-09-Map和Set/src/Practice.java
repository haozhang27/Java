import java.util.*;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/09
 */
public class Practice {
    public static List<String> subDomainVisits(String[] cpDomains) {
        Map<String, Integer> map = new HashMap<>(16);

        for (String s : cpDomains) {
            String[] splitWithSpace = s.split(" ");
            int num = Integer.valueOf(splitWithSpace[0]);
            String domain = splitWithSpace[1];

            String[] splitWithDecimal = domain.split("\\.");
            for (int i = 0; i < splitWithDecimal.length; i++) {
                String[] sub = Arrays.copyOfRange(splitWithDecimal, i, splitWithDecimal.length);
                String d = String.join(".", sub);

                int oldCount = map.getOrDefault(d, 0);
                map.put(d, oldCount + num);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String d = e.getKey();
            int n = e.getValue();
            result.add(n + " " + d);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] cpDomains = new String[] {"901 mail.com","50 yahoo.com","900 google.mail.com",
                "5 wiki.org","5 org","1 intel.mail.com","951 com"};

        List<String> ret = subDomainVisits(cpDomains);
        System.out.println(ret);
    }
}
