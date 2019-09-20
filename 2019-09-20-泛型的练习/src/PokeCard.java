public class PokeCard {
    int value;
    String colors;
    public PokeCard(int value, String colors) {
        this.value = value;
        this.colors = colors;
    }

    @Override
    public String toString () {
        return String.format("[%d, %s]", value, colors);
    }

    /**
     * equals 判断两个对象是否相等
     * obj instanceof PokeCard    表示 obj 对象是否被 PokeCard 类型的引用指向
     *                             obj 对象的类型是不是 PokeCard 类型的小类型
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof PokeCard)) {
            return false;
        }

        PokeCard other = (PokeCard)obj;

        return this.value == other.value &&
                this.colors.equals(other.colors);
    }
}
