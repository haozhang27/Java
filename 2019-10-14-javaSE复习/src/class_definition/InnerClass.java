package class_definition;

interface IA {
    void method();
}

/**
 * Demo class
 *
 * @author haozhang
 * @date 2019/10/14
 */
public class InnerClass {
    class A {}
    IA a = new IA() {
        @Override
        public void method() {

        }
    };

    void method() {
        class B {}
    }
}
