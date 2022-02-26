package normal.medium.question_0148.SortList;

import org.junit.jupiter.api.Test;
import other.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/26 13:29
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(sortList(new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))))));
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            list.add(temp);
        }

        ListNode[] nodes = list.toArray(new ListNode[]{});
        Arrays.sort(nodes, Comparator.comparingInt(i -> i.val));
        head = nodes[0];
        ListNode dummy = new ListNode(-1, head);
        for (int i = 1; i < nodes.length; i++) {
            head.next = nodes[i];
            head = head.next;
        }

        return dummy.next;
    }
}
