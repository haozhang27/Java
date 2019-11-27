import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/27
 */
public class Practice2 {
    /**
     * 成绩排序
     * 输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
     *       都按先录入排列在前的规则处理。
     */
    public void scoreSort() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            int order = Integer.parseInt(sc.nextLine());

            String[] name = new String[n];
            int[] score = new int[n];

            for (int i = 0; i < n; i++) {
                String[] arr = sc.nextLine().split(" ");
                String str = arr[0];
                int val = Integer.parseInt(arr[1]);

                if (order == 0) {
                    int j = 0;
                    for (j = i - 1; j >= 0; j--) {
                        if (score[j] < val) {
                            name[j + 1] = name[j];
                            score[j + 1] = score[j];
                        } else {
                            break;
                        }
                    }
                    name[j + 1] = str;
                    score[j + 1] = val;
                } else {
                    int j = 0;
                    for (j = i - 1; j >= 0; j--) {
                        if (score[j] > val) {
                            name[j + 1] = name[j];
                            score[j + 1] = score[j];
                        } else {
                            break;
                        }
                    }
                    name[j + 1] = str;
                    score[j + 1] = val;
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.println(name[i] + " " + score[i]);
            }
        }
    }
}
