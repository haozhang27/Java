import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 配置文件恢复
 *
 * @author haozhang
 * @date 2020/09/03
 */
public class Main1 {
    static String[] command = new String[] {"reset board", "board add", "board delete",
            "reboot backplane", "backplane abort"};
    static String[] run = new String[] {"board fault", "where to add", "no board at all",
            "impossible", "install first"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(getRet(s));
        }
    }

    public static String getRet(String s) {
        String notMatch = "unknown command";
        if (s.split(" ").length == 1) {
            return oneMatch(s);
        } else if (s.split(" ").length == 2) {
            String s0 = s.split(" ")[0];
            String s1 = s.split(" ")[1];
            List<String> combineOne = getStr(s, 0);
            List<String> combineTwo = getStr(s, 1);
            if (getCount(combineOne, s0) > 1) {
                if (getCount(combineTwo, s1) > 1) {
                    return notMatch;
                } else if (getCount(combineTwo, s1) == 1) {
                    return run[getIndex((s0 + s1))];
                }
            } else if (getCount(combineOne, s0) == 1) {
                if (getCount(combineTwo, s1) >= 1) {
                    return run[getIndex((s0 + s1))];
                }
            }
        }
        return notMatch;
    }

    public static int getIndex(String s) {
        for (int i = 0; i < command.length; i++) {
            List<String> comb = splitStr(command[i]);
            for (int j = 0; j < comb.size(); j++) {
                if (comb.get(j).equals(s)){
                    return i;
                }
            }
        }
        return 0;
    }

    public static List<String> splitStr(String s) {
        String[] arr = s.split(" ");
        List<String> combine = new ArrayList<>();
        for (int i = 0; i < arr[1].length(); i++) {
            for (int j = 0; j < arr[0].length(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[0].substring(0, j + 1));
                sb.append(arr[1].substring(0, i + 1));
                combine.add(sb.toString());
            }
        }
        return combine;
    }

    public static int getCount(List<String> combine, String s) {
        int count = 0;
        for (int i = 0; i < combine.size(); i++) {
            if (combine.get(i).equals(s)) {
                count++;
            }
        }
        return count;
    }

    public static String oneMatch(String s) {
        for (int i = 1; i < "reset".length() + 1; i++) {
            String ns = "reset".substring(0, i);
            if (s.equals(ns)) {
                return "reset what";
            }
        }
        return "unknown command";
    }

    public static List<String> getStr(String s, int flag) {
        List<String> combineOne = new ArrayList<>();
        List<String> combineTwo = new ArrayList<>();
        for (int i = 0; i < command.length; i++) {
            String s0 = command[i].split(" ")[0];
            String s1 = command[i].split(" ")[1];
            for (int j = 1; j < s0.length() + 1; j++) {
                combineOne.add(s0.substring(0, j));
            }
            for (int j = 1; j < s1.length() + 1; j++) {
                combineTwo.add(s1.substring(0, j));
            }
        }

        if (flag == 0) {
            return combineOne;
        } else {
            return combineTwo;
        }
    }
}
