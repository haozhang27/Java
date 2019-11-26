/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/11/26
 */
public class Practice1 {
    public String countOfSweets(int y1, int y2, int y3, int y4) {
        StringBuilder sb = new StringBuilder();
        float a = (y1 + y3) / 2f;
        float b = (y3 - y1) / 2f;
        float c = (y4 - y2) / 2f;
        if ((a - ((y1 + y3) / 2)) != 0) {
            return "No";
        }

        if ((b - (y3 - y1) / 2) != 0 || (b != ((y2 + y4) / 2))) {
            return "No";
        }

        if ((c - ((y4 - y2) / 2)) != 0) {
            return "No";
        }

        int ar = (int)a;
        int br = (int)b;
        int cr = (int)c;
        sb.append(ar);
        sb.append(" ");
        sb.append(br);
        sb.append(" ");
        sb.append(cr);
        return sb.toString();
    }
}
