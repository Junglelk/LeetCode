package normal.medium.question_0019.RemoveNthNodeFromEndOfList;

import org.junit.jupiter.api.Test;
import other.ListNode;

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
    }

    /**
     * 官解，先后指针，挺好的思路
     *
     * @param head 头节点
     * @param n    倒数第 n 个节点
     * @return 删除后的链表
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
