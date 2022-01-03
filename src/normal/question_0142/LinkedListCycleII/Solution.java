package normal.question_0142.LinkedListCycleII;

import org.junit.jupiter.api.Test;
import other.ListNode;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * <p>
 * Do not modify the linked list.
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/11 22:29
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(detectCycle(new ListNode(1, new ListNode(2))));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while (true) {
            if (first == null || first.next == null) {
                return null;
            }
            first = first.next.next;
            second = second.next;

            if (first == second) {
                ListNode pointer = head;
                // 这个似乎有点什么计算，但我没看明白
                while (pointer != second) {
                    pointer = pointer.next;
                    second = second.next;
                }
                return pointer;
            }
        }
    }
}
