import java.util.Scanner;

/**
 * 根据输入的日期，计算是这一年的第几天。。
 *
 * 详细描述：
 *
 * 输入某年某月某日，判断这一天是这一年的第几天？。
 *
 * 测试用例有多组，注意循环输入
 *
 * @author haozhang
 * @date 2020/09/05
 */
public class Main {
    private static int[] MONTHS = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            System.out.println(iConverDateToDay(year, month, day));
        }
    }

    public static int iConverDateToDay(int year, int month, int day) {
        /* 在这里实现功能，将结果填入输入数组中*/
        if (month < 1 || month > 12) {
            return -1;
        } else if (day < 1 || day > 31) {
            return -1;
        } else if (isLeapYear(year)) {
            if (month == 1) {
                int ret = 0;
                ret += day;
                return ret;
            } else if (month == 2) {
                int ret = 0;
                ret += MONTHS[0];
                ret += day;
                return ret;
            } else {
                int ret = 1;
                for (int i = 0; i < month - 1; i++) {
                    ret += MONTHS[i];
                }
                ret += day;

                return ret;
            }
        } else if (!isLeapYear(year)) {
            int ret = 0;
            for (int i = 0; i < month - 1; i++) {
                ret += MONTHS[i];
            }
            ret += day;

            return ret;
        } else {
            return -1;
        }
    }

    public static int getOutDay() {
        return 0;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }

        if (year % 400 == 0) {
            return true;
        }

        return false;
    }
}
