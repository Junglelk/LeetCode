package normal.easy.question_0083.RemoveDuplicatesFromSortedList;

import other.ListNode;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/9 21:36
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode i;
        ListNode j;
        i = head;
        j = head.next;
        while (i.next != null) {
            if (i.val == j.val) {
                j = j.next;
                i.next = j;
            } else {
                i = i.next;
                j = j.next;
            }
        }
        return head;
    }
}
