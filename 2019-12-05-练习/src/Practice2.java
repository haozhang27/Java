import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/09/19
 */
public class Practice2 {
    /**
     * 输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票。
     * 每行输出候选人的名字和得票数量。
     */
    public void countOfVotes() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int candidateNum = Integer.parseInt(sc.nextLine());
            String[] candidateName = sc.nextLine().split(" ");

            int voteNum = Integer.parseInt(sc.nextLine());
            String[] voteName = sc.nextLine().split(" ");

            Map<String, Integer> map = new HashMap<>(16);
            for (int i = 0; i < voteName.length; i++) {
                int n = map.getOrDefault(voteName[i], 0);
                map.put(voteName[i], n + 1);
            }

            int num = 0;
            for (int i = 0; i < candidateNum; i++) {
                String s = candidateName[i];
                if (!map.containsKey(s)) {
                    System.out.println(s + " : " + 0);
                } else {
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        String key = entry.getKey();
                        int val = entry.getValue();
                        if (key.equals(s)) {
                            System.out.println(s + " : " + val);
                            num += val;
                        }
                    }
                }
            }
            System.out.println("Invalid : " + (voteNum - num));
        }
    }
}
