package normal.medium.question_0082.RemoveDuplicatesFromSortedListII;

import org.junit.Test;
import other.ListNode;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * <p>
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/9 22:02
 */
public class Solution {


    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        System.out.println(head);
        System.out.println(deleteDuplicates(head));
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int x = head.next.val;
                while (head.next.next != null && head.next.next.val == x) {
                    head.next = head.next.next;
                }
            } else {
                head.next = head.next.next;
            }
        }
        return dummy.next;
    }
}
