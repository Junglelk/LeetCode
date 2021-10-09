package question_0203.RemoveLinkedListElements;

import other.ListNode;

/**
 * Description:
 * <p>
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/10/9 15:26
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode j = new ListNode(-1, head);
        ListNode i = j;
        while (i != null) {
            if (i.next != null && (i.next.val == val || i.val == val)) {
                i.next = i.next.next;
            } else {
                i = i.next;
            }
        }
        return j.next;
    }
}
