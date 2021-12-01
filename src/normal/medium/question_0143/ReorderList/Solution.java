package normal.medium.question_0143.ReorderList;

import org.junit.Test;
import other.ListNode;

import java.util.Deque;
import java.util.LinkedList;

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
        reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }


    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode p = head.next;
        Deque<ListNode> stack = new LinkedList<>();
        int a = 0;
        while (p != null) {
            p = p.next;
            a++;
        }
        p = head.next;
        int count = a % 2 == 0 ? a / 2 : a / 2 + 1;
        a = 0;
        while (p != null) {
            a++;
            if (a == count - 1) {
                p = p.next;
                while (count != -1) {
                    ListNode temp = p;
                    if (p == null) {
                        break;
                    }
                    p = p.next;
                    temp.next = null;
                    stack.push(temp);
                    count--;
                }
                break;
            }
            p = p.next;
        }
        p = head;
        a = 0;
        while (stack.size() != 1) {
            if (a == 0) {
                ListNode temp = p.next;
                p.next = stack.pop();
                p = p.next;
                p.next = temp;
                a--;
            } else {
                p = p.next;
                a++;
            }
        }
        System.out.println(head);
    }
}
