package interview.ch02.PartitionList;

import other.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write code to partition a linked list around a value x,
 * <p>
 * such that all nodes less than x come before all nodes greater than or equal to x.
 * <p>
 * If x is contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你不需要 保留 每个分区中各节点的初始相对位置
 * <pre>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/02/01 19:20
 */
public class Solution {
    /**
     * 原描述就是一个粒度很大的排序，所以我直接取出来数据，然后进行小粒度的排序，再还原成链表。
     * <p>
     * 时间、空间复杂度都会很高，所以不是很好的一种实现，权当联系链表操作了。
     *
     * @param head 头节点
     * @param x    THRESHOLD
     * @return 结果链表
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (head.next != null) {
            head = head.next;
            list.add(head.val);
        }
        Integer[] array = list.toArray(new Integer[]{});
        Arrays.sort(array);
        ListNode node = new ListNode();
        head = node;
        for (int i = 0; i < array.length; i++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return head.next;
    }
}