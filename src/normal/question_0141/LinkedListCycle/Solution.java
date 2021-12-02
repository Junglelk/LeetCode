package normal.question_0141.LinkedListCycle;

import org.junit.Test;
import other.ListNode;

/**
 * Description:
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/10/9 14:15
 */
public class Solution {
    @Test
    public void test() {

        ListNode a = new ListNode(3);
        a.next = new ListNode(2);
//        ListNode b = a.next;
        a.next.next = new ListNode(0);
        a.next.next.next = new ListNode(4);
//        a.next.next.next.next = b;
        System.out.println(hasCycle(a));
    }

    public boolean hasCycle(ListNode head) {
        if (head.next == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = head;
        while (true) {
            if (first.next == null) {
                return false;
            }
            first = first.next.next;
            second = second.next;
            if (first == null || second == null) {
                return false;
            }
            if (first.next == second) {
                return true;
            }
        }
    }
}
