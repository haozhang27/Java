import java.util.ArrayList;
import java.util.Stack;

/**
 * Demo class
 *
 * @author haozhang
 * @date 2020/05/03
 */
public class Main {

    /**
     * 由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈
     * 给定一个操作序列int[][2]
     * 每个操作的第一个数代表操作类型，若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作
     * @param ope
     * @param size
     * @return
     */
    public static ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        //先把所有经push  pop后的数放在一个栈中
        Stack<Integer> stack = new Stack<>();

        //存放结果
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0] == 1) {
                stack.push(ope[i][1]);
            }

            if (ope[i][0] == 2 && stack.size() > 0) {
                stack.pop();
            }
        }


        //因为要保证和数组中的顺序相同，得到的栈需要先出栈 再进一次栈
        Stack<Integer> newStack = getStack(stack);

        //栈中的数的个数是否满足  size的整数倍
        int consult = newStack.size() / size;

        //如果栈中的数的个数不是 size的整数倍  知道剩余的数是几个
        int remainder = newStack.size() % size;


        if (remainder == 0) {
            //按照size的大小 搞出 list
            while (!newStack.isEmpty()) {
                ArrayList<Integer> list = getArrays(newStack, size);
                ret.add(list);
            }
        } else {
            //先把 是 size整数倍的部分的数 高出list
            while (!newStack.isEmpty() && consult > 0) {
                ArrayList<Integer> list1 = getArrays(newStack, size);
                ret.add(list1);
                consult--;
            }

            //再把余下的几个数  搞成 list
            int num = remainder;
            ArrayList<Integer> list = new ArrayList<>();
            while (num > 0) {
                list.add(newStack.pop());
                num--;
            }
            ret.add(list);
        }

        return ret;
    }

    /**
     * 获得ArrayList
     * @param stack
     * @param size
     * @return
     */
    public static ArrayList<Integer> getArrays(Stack<Integer> stack, int size) {
        int s = size;
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() && s > 0) {
            while (s > 0) {
                list.add(stack.pop());
                s--;
            }
        }
        return list;
    }

    /**
     * 获得顺序相反的栈
     * @param stack
     * @return
     */
    public static Stack<Integer> getStack(Stack<Integer> stack) {
        Stack<Integer> newStack = new Stack<>();
        while (!stack.isEmpty()) {
            newStack.push(stack.pop());
        }
        return newStack;
    }


    /**
     * 判断链表是否位回文数
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        // write code here
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode begin = getMidNode(head, size);
        ListNode cur1 = begin;
        while (cur1 != null) {
            stack.push(cur1);
            cur1 = cur1.next;
        }
        System.out.println("==");

        ListNode cur2 = head;
        while (cur2 != null && !stack.isEmpty()) {
            if (cur2.val != stack.pop().val) {
                return false;
            }
            cur2 = cur2.next;
        }
        return true;
    }

    /**
     * 获取中位数
     * @param size
     * @return
     */
    public static int getMid(int size) {
        int mid;
        if (size % 2 == 0) {
            mid = size / 2;
        } else {
            mid = (size / 2) - 1;
        }
        return mid;
    }

    /**
     * 获取中间节点的下一个节点
     * @param head
     * @param size
     * @return
     */
    public static ListNode getMidNode(ListNode head, int size) {
        if (size % 2 == 0) {
            ListNode cur = head;
            int mid = getMid(size);
            while (mid > 0) {
                cur = cur.next;
                mid--;
            }
            return cur;
        } else {
            ListNode cur = head;
            int mid = getMid(size);
            while (mid > 0) {
                cur = cur.next;
                mid--;
            }
            return cur.next.next;
        }
    }
}
