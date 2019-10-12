/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/12
 */
public class Card {
    public int value;
    public String color;

    public Card (int value, String color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public int hashCode() {
        return value ^ color.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        //if (obj.getClass() == this.getClass()) { return false; }
        if (!(obj instanceof Card)) {
            return false;
        }

        Card c = (Card)obj;
        return value == c.value && color.equals(c.color);
    }
}
