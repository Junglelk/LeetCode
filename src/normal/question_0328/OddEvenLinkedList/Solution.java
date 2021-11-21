package normal.question_0328.OddEvenLinkedList;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        for (int i = 1; i <+ 5; i++) {
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
        while (even != null && even.next != null){//结束条件为even走到最终位置。
            odd.next = even.next;//这个奇数指向下一个奇数，而下一个奇数是偶数的下一个
            odd = odd.next;//移动指针
            even.next = odd.next;//同上
            even = even.next;
        }
        odd.next = eHead;

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
