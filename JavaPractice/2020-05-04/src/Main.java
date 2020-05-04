import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/05/04
 */
public class Main {
    /**
     * 猫狗收容所
     * @param ope
     * @return
     */
    public static ArrayList<Integer> asylum(int[][] ope) {
        ArrayList<Integer> ret = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> cat = new LinkedList<>();
        Queue<Integer> dog = new LinkedList<>();
        for (int i = 0; i < ope.length; i++) {
            int order = ope[i][0];
            int serial = ope[i][1];
            if (order == 1) {

                queue.add(serial);
                if (serial > 0) {
                    dog.add(serial);
                } else if (serial < 0) {
                    cat.add(serial);
                }
            }

            if (order == 2) {
                if (serial == 0 && !queue.isEmpty()) {
                    int num = queue.poll();
                    ret.add(num);
                    if (num > 0) {
                        dog.poll();
                    }
                    if (num < 0) {
                        cat.poll();
                    }
                } else if (serial > 0 && !dog.isEmpty()) {
                    int num = dog.poll();
                    ret.add(num);
                    queue.remove(num);
                } else if (serial < 0 && !cat.isEmpty()) {
                    int num = cat.poll();
                    ret.add(num);
                    queue.remove(num);
                }
            }
        }
        return ret;
    }

    public static ArrayList<Integer> twoStacksSort(int[] nums) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            stack1.push(nums[i]);
        }


        while (!stack1.isEmpty()) {
            int num = stack1.pop();
            while (!stack2.isEmpty() && stack2.peek() > num) {
                stack1.push(stack2.pop());
            }
            stack2.push(num);

        }

        while (!stack2.isEmpty()) {
            ret.add(stack2.pop());
        }

        return ret;
    }
}
