package normal.medium.question_0328.OddEvenLinkedList;

import other.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 * <p>
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *  
 * <p>
 * Constraints:
 * <p>
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * The length of the linked list is between [0, 10^4].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/odd-even-linked-list">odd-even-linked-list</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/1 11:21
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        for (int i = 1; i < +5; i++) {
            ListNode temp = new ListNode(i);
            temp.next = head.next;
            head.next = temp;
        }
        System.out.println(oddEvenList(head));
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode eHead = head.next;
        ListNode even = eHead;
        while (even != null && even.next != null) {//结束条件为even走到最终位置。
            odd.next = even.next;//这个奇数指向下一个奇数，而下一个奇数是偶数的下一个
            odd = odd.next;//移动指针
            even.next = odd.next;//同上
            even = even.next;
        }
        odd.next = eHead;

        return head;
    }
}
