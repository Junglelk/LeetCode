package normal.easy.question_0206.ReverseLinkedList;

import org.junit.jupiter.api.Test;
import other.ListNode;

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
            return head;
        }
        ListNode p = null;
        ListNode q = head;
        while (q != null) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }

}
