package normal.medium.question_0024.SwapNodesInPairs;

import org.junit.jupiter.api.Test;
import other.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/18 21:34
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
    }

    /**
     * 0 -> 1 -> 2 -> 3 -> 4
     *
     * @param head 头节点
     * @return 返回节点
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode p1 = p.next;
            ListNode p2 = p.next.next;
            // 这就像是交换数组的两个元素一样
            p.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            p = p1;
        }
        return dummy.next;
    }

}
