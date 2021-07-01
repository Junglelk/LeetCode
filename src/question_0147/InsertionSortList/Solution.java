package question_0147.InsertionSortList;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        /**
         * 1. 取下节点
         *  temp = head.next;
         *  head.next = temp.next;
         *  temp.next = null;
         * 2. 遍历链表
         * 3. 比较
         * 4. 插入节点
         */
        ListNode tempList = head;

        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
