package interview.ch02.question_05.SumLists;

import org.junit.jupiter.api.Test;
import other.ListNode;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * <p>
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/02/02 22:24
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(addTwoNumbers(new ListNode(5), new ListNode(5)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int advance = 0;
        ListNode result = new ListNode(-1);
        ListNode head = result;
        while (l1 != null || l2 != null || advance != 0) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int temp = (a + b + advance) % 10;
            result.next = new ListNode(temp);
            advance = (a + b + advance) / 10;
            result = result.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head.next;
    }
}
