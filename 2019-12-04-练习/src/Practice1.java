import java.util.Scanner;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/12/04
 */
public class Practice1 {
    public void scoreGPA() {
        /**
         *
         * 北京大学对本科生的成绩施行平均学分绩点制（GPA）。既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。
         * 公式如下：
         * 实际成绩 绩点
         * 90——100 4.0
         * 85——89 3.7
         * 82——84 3.3
         * 78——81 3.0
         * 75——77 2.7
         * 72——74 2.3
         * 68——71 2.0
         * 64——67 1.5
         * 60——63 1.0
         * 60以下 0
         * 1．一门课程的学分绩点=该课绩点*该课学分
         * 2．总评绩点=所有学科绩点之和/所有课程学分之和
         *编写程序求出某人A的总评绩点（GPA）。
         *
         * 第一行 总的课程数n（n<10）；
         * 第二行 相应课程的学分（两个学分间用空格隔开）；
         * 第三行 对应课程的实际得分；
         * 此处输入的所有数字均为整数。
         */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] score1 = new int[n];
            for (int i = 0; i < n; i++) {
                score1[i] = sc.nextInt();
            }

            int[] score2 = new int[n];
            for (int i = 0; i < n; i++) {
                score2[i] = sc.nextInt();
            }

            double[] score = new double[n];
            for (int i = 0; i < score2.length; i++) {
                if (score2[i] >= 90 && score2[i] <= 100) {
                    score[i] = 4.0;
                }
                if (score2[i] >= 85 && score2[i] <= 89) {
                    score[i] = 3.7;
                }
                if (score2[i] >= 82 && score2[i] <= 84) {
                    score[i] = 3.3;
                }
                if (score2[i] >= 78 && score2[i] <= 81) {
                    score[i] = 3.0;
                }
                if (score2[i] >= 75 && score2[i] <= 77) {
                    score[i] = 2.7;
                }
                if (score2[i] >= 72 && score2[i] <= 74) {
                    score[i] = 2.3;
                }
                if (score2[i] >= 68 && score2[i] <= 71) {
                    score[i] = 2.0;
                }
                if (score2[i] >= 64 && score2[i] <= 67) {
                    score[i] = 1.5;
                }
                if (score2[i] >= 60 && score2[i] <= 63) {
                    score[i] = 1.0;
                }
                if (score2[i] < 60) {
                    score[i] = 0;
                }
            }

            double[] score3 = new double[n];
            for (int i = 0; i < score2.length; i++) {
                score3[i] = (double)score1[i] * score[i];
            }

            double num1 = 0;
            for (int i = 0; i < score1.length; i++) {
                num1 += score1[i];
            }

            double num2 = 0;
            for (int i = 0; i < score3.length; i++) {
                num2 += score3[i];
            }

            double GPA = num2 / num1;
            System.out.printf("%.2f", GPA);

        }
    }
}
