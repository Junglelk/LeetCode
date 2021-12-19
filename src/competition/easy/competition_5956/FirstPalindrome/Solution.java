package competition.easy.competition_5956.FirstPalindrome;

/**
 * Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
 * <p>
 * A string is palindromic if it reads the same forward and backward.
 * <p>
 * 给你一个字符串数组 words ，找出并返回数组中的 第一个回文字符串 。如果不存在满足要求的字符串，返回一个 空字符串 "" 。
 * <p>
 * 回文字符串 的定义为：如果一个字符串正着读和反着读一样，那么该字符串就是一个 回文字符串 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-palindromic-string-in-the-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/19 15:22
 */
public class Solution {
    public String firstPalindrome(String[] words) {
        normal.question_0131.PalindromePartitioning.Solution solution = new normal.question_0131.PalindromePartitioning.Solution();
        for (String temp : words) {
            if (solution.isPalindrome(temp)) {
                return temp;
            }
        }
        return "";
    }
}
