import org.junit.Test;
import other.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jungle
 * @since 2021/10/17 10:29
 */
public class TempSolution {

    @Test
    public void test() {
        // []
        //3
        System.out.println(timeRequiredToBuy(new int[]{84, 49, 5, 24, 70, 77, 87, 8}, 3));
    }

    /**
     * <pre>
     * 输入：tickets = [2,3,2], k = 2
     * 输出：6
     * 解释：
     * - 第一轮，队伍中的每个人都买到一张票，队伍变为 [1, 2, 1] 。
     * - 第二轮，队伍中的每个都又都买到一张票，队伍变为 [0, 1, 0] 。
     * 位置 2 的人成功买到 2 张票，用掉 3 + 3 = 6 秒。
     * </pre>
     *
     * @param tickets 数组
     * @param k       位置
     * @return
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int rounds = 0;
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    rounds++;
                    tickets[i] -= 1;
                    if (tickets[k] == 0) {
                        break;
                    }
                }
            }
        }
        return rounds;
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = head;
        int length = 0;
        while (dummy != null) {
            length++;
            dummy = dummy.next;
        }
        int nums = (int) ((-1 + Math.sqrt(1.0 + 8 * length)) / 2) + 1;
        int[] arrays = new int[nums];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = i;
        }
        dummy = head;
        ListNode tail;
        for (int array : arrays) {
            int temp = 0;
            if (array % 2 == 0) {
                ListNode point = dummy;
                while (temp < array) {
                    dummy = dummy.next;
                    temp++;
                }
                tail = reverse(point);
                dummy.next = tail;
            } else {
                while (temp < array) {
                    dummy = dummy.next;
                    temp++;
                }
            }
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode dummy;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        dummy = head;
        while (!stack.isEmpty()) {
            head.next = stack.pop();
            head = head.next;
        }
        return dummy;
    }

}
