import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/13
 */
public final class MyString implements Comparable<MyString> {
    private final char[] value;

    // 列出 public 方法

    /**
     * 将字符数组中的所有内容变为字符串
     *
     * 需要复制数组，保证数组的引用不会被泄露；泄露会导致通过泄露的引用，修改属性的值；
     * 从而破坏对象的不可变特性。
     *
     * @param value 字符串数组
     */
    public MyString(char[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    /**
     * 将字符数组中的部分内容变为字符串
     * @param value 字符数组
     * @param offset 起始位置
     * @param count 结束位置
     */
    public MyString(char[] value, int offset, int count) {
        this.value = Arrays.copyOfRange(value, offset, offset + count);
    }

    /**
     * 这里引用泄露没有问题，因为新的对象也不会去修改 value 数组中的值
     * 相比较于 copyOf 可以节省复制的时间空间，提高效率
     * @param s 对象
     */
    public MyString(MyString s) {
        /**
         * this.value = Arrays.copyOf(s.value, s.value.length);
         */

        this.value = s.value;
    }

    /**
     * 模拟的对象常量池
     */
    private static List<MyString> pool = new ArrayList<>();

    /**
     * 自动入池
     * 模拟直接定义字符串
     * 会直接入池
     */
    public static MyString literal(MyString s) {
        for (MyString ms : pool) {
            if (ms.equals(s)) {
                return ms;
            }
        }

        MyString rs = new MyString(s);
        pool.add(rs);
        return rs;
    }

    /**
     * 手动入池
     *如果常量池中已经有该相等的对象，返回引用
     *否则在常量池中创建对象，并返回引用
     */
    public MyString intren() {
        for (MyString ms : pool) {
            if (ms.equals(this)) {
                return ms;
            }
        }

        MyString rs = new MyString(this);
        pool.add(rs);
        return rs;
    }



    /**
     * 得到 index 处的字符
     * @param index 要索取的位置
     * @return -1 表示索取位置不合法，其他表示 索取到的 index 处的字符
     */
    public char charAt(int index) {
        if (index < 0 || index >= value.length) {
            return (char)-1;
        }
        return value[index];
    }

    /**
     * 将字符串变为字符数组
     * 不能直接返回引用，防止引用泄露
     * @return 数组
     */
    public char[] toCharArray() {
        return Arrays.copyOf(value, value.length);
    }

    /**
     * 不区分大小写的比较
     * @param s 要比较的对象
     * @return true 表示相等；false 表示不等
     */
    public boolean equalsIgnoreCase(MyString s) {
        //return toUpper().equals(s.toUpper());

        if (s == null) {
            return false;
        }

        if (value.length != s.value.length) {
            return false;
        }

        for (int i = 0; i < value.length; i++) {
            char a = value[i];
            char b = s.value[i];

            if (a == b) {
                continue;
            }

            if (a >= 'a' && a <= 'z') {
                a += ('A' - 'a');
                if (a == b) {
                    continue;
                }
            } else if (a >= 'A' && a <= 'Z') {
                a += ('a' - 'A');
                if (a == b) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    /**
     * 将小写字母转化为大写字母
     * 1.构造新的对象
     * 2.遍历新对象的 value
     * 3.把 小写字母转换成大写字母
     * 4.返回新的对象
     * @return 转换后的对象
     */
    public MyString toUpper() {
        MyString s = new MyString(value);
        for (int i = 0; i < s.value.length; i++) {
           if (s.value[i] >= 'a' && s.value[i] <= 'z') {
               s.value[i] = (char)(s.value[i] - 'a' + 'A');
           }
        }
        return s;
    }

    /**
     * 将大写字母转化为小写字母
     * @return 转换后的对象
     */
    public MyString toLower() {
        MyString s = new MyString(value);
        for (int i = 0; i < s.value.length; i++) {
            if (s.value[i] >= 'A' && s.value[i] <= 'Z') {
                s.value[i] = (char)(s.value[i] - 'A' + 'a');
            }
        }
        return s;
    }

    /**
     * 比较两个对象是否相等
     * 1.判断引用是否指向同一个对象
     * 2.判断引用是否为空， （o 是不是 null）
     * 3.判断是否为同一类型， （o 是不是一个 MyString 类型的对象）
     * 4.判断值是否相等， （属性的相等性）
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        //s.getClass() == getClass()
        if (!(o instanceof MyString)) {
            return false;
        }

        return Arrays.equals(value, ((MyString) o).value);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (char c : value) {
            hash = (hash ^ c);
        }
        return hash;
    }

    /**
     * 截取部分内容
     * @param begin 开始截取位置
     * @param end 结束位置
     * @return 截取的部分
     */
    public MyString subString(int begin, int end) {
        return new MyString(value, begin, end - begin);
    }

    /**
     * 将 value 与 o 作比较
     * @param o 要比较的对象
     * @return 负数表示 value 比 o 大；正数表示 value 比 o 小； 0 表示 value 与 o 相等
     */
    @Override
    public int compareTo(MyString o) {
        if (o == null) {
            return 1;
        }

        int length = Math.min(value.length, o.value.length);
        for (int i = 0; i < length; i++) {
            char a = value[i];
            char b = o.value[i];
            if (a < b) {
                return -1;
            } else if (a > b) {
                return -1;
            }
        }

        if (value.length > o.value.length) {
            return 1;
        } else if (value.length < o.value.length) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return new String(value);
    }

    public static void main(String[] args) {
        char[] a = { 'a', 'b', 'c'};
        MyString s = new MyString(a);
        MyString t = new MyString(s);

        System.out.println(s);
        System.out.println(t);
        System.out.println(s.equals(t));

        MyString ret = t.toUpper();
        System.out.println(s);
        System.out.println(t);
        System.out.println(s.equals(t));
        System.out.println(ret);

        MyString ret2 = ret.toLower();
        System.out.println(ret2);
    }
}
