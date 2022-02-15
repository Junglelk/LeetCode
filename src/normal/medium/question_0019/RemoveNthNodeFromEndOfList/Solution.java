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
//        System.out.println(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(removeNthFromEnd(new ListNode(1), 1));
//        System.out.println(reverse(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head);
        int k = 0;
        ListNode temp = head;
        while (temp != null) {
            if (k == n - 1) {
                ListNode point = temp.next;
                temp.next = temp.next.next;
                point.next = null;
            }
            temp = temp.next;
            k++;
        }
        return head == null ? null : reverse(head);
    }

    public ListNode reverse(ListNode head) {
        ListNode hair;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            hair = head.next;
            head.next = null;
            stack.push(head);
            head = hair;
        }
        hair = stack.pop();
        head = hair;
        while (!stack.isEmpty()) {
            hair.next = stack.pop();
            hair = hair.next;
        }
        return head;
    }
}
