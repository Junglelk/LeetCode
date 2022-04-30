package interview.ch03.medium.question_03.StackOfPlates;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 * <p>
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/stack-of-plates-lcci">https://leetcode-cn.com/problems/stack-of-plates-lcci</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/4/30 23:20
 */
public class Solution {

    @Test
    public void test() {
        StackOfPlates stack = new StackOfPlates(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.popAt(0));
        System.out.println(stack.popAt(0));
        System.out.println(stack.popAt(0));
    }

}

class StackOfPlates {

    List<Deque<Integer>> stacks = new ArrayList<>();
    int cap;


    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if (stacks.size() == 0 || stacks.get(stacks.size() - 1).size() == cap) {
            Deque<Integer> stack = new LinkedList<>();
            stacks.add(stack);
        }
        stacks.get(stacks.size() - 1).push(val);
    }

    public int pop() {
        if (stacks.size() == 0) {
            return -1;
        } else {
            for (int i = stacks.size() - 1; i >= 0; i--) {
                Deque<Integer> stack = stacks.get(i);
                if (stack.size() != 0) {
                    return stack.pop();
                }
            }
            return -1;
        }
    }

    public int popAt(int index) {
        if (index < stacks.size()) {
            Deque<Integer> stack = stacks.get(index);
            if (stack.size() != 0) {
                return stack.pop();
            }

            for (int i = stacks.size() - 1; i >= 0; i--) {
                stack = stacks.get(i);
                if (stack.size() != 0) {
                    return stack.pop();
                }
            }
            return 0;
        } else {
            return -1;
        }
    }
}