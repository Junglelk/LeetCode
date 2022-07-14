package normal.easy.question_0234.PalindromeLinkedList;

import org.junit.jupiter.api.Test;
import other.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <p>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/palindrome-linked-list">palindrome-linked-list</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1)))));
        System.out.println(isPalindrome(new ListNode(1)));
        System.out.println(isPalindrome(new ListNode(1, new ListNode(0))));
    }


    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        List<Integer> vals = new ArrayList<>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}



