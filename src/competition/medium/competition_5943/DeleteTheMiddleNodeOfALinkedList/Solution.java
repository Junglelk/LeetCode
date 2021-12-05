package competition.medium.competition_5943.DeleteTheMiddleNodeOfALinkedList;

import other.ListNode;

/**
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 * <p>
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
 * <p>
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 * <p>
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 * <p>
 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 * <p>
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-the-middle-node-of-a-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/5 15:05
 */
public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        if (length == 1) {
            return null;
        }
        int mid = length / 2;
        ListNode pre = head;
        ListNode next = head.next;
        int point = 1;
        while (next != null) {
            if (point == mid) {
                pre.next = next.next;
                break;
            } else {
                pre = pre.next;
                next = next.next;
                point++;
            }
        }
        return head;
    }
}
