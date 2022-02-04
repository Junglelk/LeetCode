package interview.ch02.question_08.LinkedListCycle;

import other.ListNode;

/**
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * <p>
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 * <p>
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/02/04 09:52
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while (true) {
            if (first.next == null) {
                return null;
            }
            first = first.next.next;
            second = second.next;
            if (first == null || second == null) {
                return null;
            }
            if (first == second) {
                ListNode ptr = head;
                while (ptr != second) {
                    ptr = ptr.next;
                    second = second.next;
                }
                return ptr;
            }
        }
    }
}

