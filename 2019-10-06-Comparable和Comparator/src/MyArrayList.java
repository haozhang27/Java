import java.util.List;
import java.util.ListIterator;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/06
 */
public class MyArrayList<E> implements List<E> {
    private E[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        //泛型无法定义泛型数组
        //有一个压制警告的注解
        array = (E[])new Object[100];
    }

    public void add(E element) {
        array[size++] = element;
    }

    public void remove() {
        //size-- 的写法会引发内存泄漏
        //原本语义上应该死去的对象，因为写法问题，导致没有被GC判定为垃圾，导致内存泄漏
        array[--size] = null;
        size--;
    }
}
