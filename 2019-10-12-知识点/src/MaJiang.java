/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/12
 */
public class MaJiang implements Comparable<MaJiang> {
    public String color;
    public String value;

    public MaJiang (String color, String value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public int compareTo (MaJiang o) {
        return this.value.compareTo(o.value);
    }
}
