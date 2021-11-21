package normal.question_0206.ReverseLinkedList;

import org.junit.Test;
import other.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/9 21:00
 */
public class Solution {
    @Test
    public void test() {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(reverseList(head));

    }


    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        Deque<ListNode> stack = new ArrayDeque<>();

        while (head.next != null) {
            ListNode point;
            point = head;
            head = head.next;
            point.next = null;
            stack.push(point);
        }
        stack.push(head);
        ListNode left;
        ListNode right;
        left = stack.pop();
        right = stack.pop();
        left.next = right;
        while (!stack.isEmpty()) {
            right.next = stack.pop();
            right = right.next;
        }
        return left;
    }

}
