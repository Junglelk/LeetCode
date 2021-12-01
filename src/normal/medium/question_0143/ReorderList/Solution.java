package normal.medium.question_0143.ReorderList;

import org.junit.Test;
import other.ListNode;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <pre>
 *      L0 → L1 → … → Ln - 1 → Ln
 *  </pre>
 * Reorder the list to be on the following form:
 * <pre>
 *      L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *  </pre>
 * <p>
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <pre>
 *     L0 → L1 → … → Ln - 1 → Ln
 * </pre>
 * 请将其重新排列后变为：
 * <pre>
 *      L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *  </pre>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/1 21:04
 */
public class Solution {

    @Test
    public void test() {
        reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7))))))));
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
        System.out.println(head);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            // 取下l1
            l1_tmp = l1.next;
            // 取下l2
            l2_tmp = l2.next;

            // l1指向l2
            l1.next = l2;
            // 恢复l1
            l1 = l1_tmp;

            // l2 指向l1
            l2.next = l1;
            // 恢复l2
            l2 = l2_tmp;
        }
    }
}