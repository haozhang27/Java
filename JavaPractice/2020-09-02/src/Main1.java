import java.util.Scanner;

/**
 * MP3光标位置
 *
 * @author haozhang
 * @date 2020/09/02
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int len = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();
            getSong(len, s);
        }
    }

    public static void getSong(int len, String s) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i + 1;
        }

        int cursor = 0;
        int winpos = 0;
        if (len <= 4) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'U') {
                    if (cursor == 0) {
                        cursor = len - 1;
                    } else {
                        cursor--;
                    }
                } else {
                    if (cursor == len - 1) {
                        cursor = 0;
                    } else {
                        cursor++;
                    }
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'U') {
                    if (cursor == 0) {
                        cursor = len - 1;
                        winpos = len - 4;
                    } else {
                        if (cursor == winpos) {
                            cursor--;
                            winpos--;
                        } else {
                            cursor--;
                        }
                    }
                } else {
                    if (cursor == len - 1) {
                        winpos = 0;
                        cursor = 0;
                    } else {
                        if (cursor == winpos + 3) {
                            cursor++;
                            winpos++;
                        } else {
                            cursor++;
                        }
                    }
                }
            }
        }

        if (winpos + 4 < arr.length) {
            for (int i = winpos; i < winpos + 4; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = winpos; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        System.out.println(arr[cursor]);
    }
}
