package normal.easy.question_0009.PalindromeNumber;

import org.junit.jupiter.api.Test;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 * <p>
 * Input: x = -101
 * Output: false
 *  
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/palindrome-number">palindrome-number</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    void test() {
        System.out.println(isPalindrome(101));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x;
        int length = 0;
        while (temp != 0) {
            temp /= 10;
            length++;
        }
        int[] ary = new int[length];
        while (x != 0) {
            ary[temp++] = x % 10;
            x /= 10;
        }
        boolean flag = true;
        temp = 0;
        int j = ary.length - 1;
        while (temp < j) {
            if (ary[temp++] != ary[j--]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
