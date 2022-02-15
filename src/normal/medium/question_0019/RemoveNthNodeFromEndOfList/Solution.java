package normal.medium.question_0019.RemoveNthNodeFromEndOfList;

import org.junit.jupiter.api.Test;
import other.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/15 21:05
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(removeNthFromEnd(new ListNode(1), 1));
//        System.out.println(reverse(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = null;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            hair = head.next;
            head.next = null;
            stack.push(head);
            head = hair;
        }
        int size = stack.size();
        head = hair = new ListNode(-1);
        int k = 0;
        while (!stack.isEmpty()) {
            if (k == size - n) {
                stack.pollLast();
            } else {
                hair.next = stack.pollLast();
                hair = hair.next;
            }
            k++;
        }
        return head.next;
    }
}
