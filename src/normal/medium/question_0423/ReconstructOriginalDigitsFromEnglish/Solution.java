package normal.medium.question_0423.ReconstructOriginalDigitsFromEnglish;

import java.util.Arrays;

/**
 * Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.
 * <p>
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 *
 * <pre>
 * 输入：s = "owoztneoer"
 * 输出："012"
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/24 21:20
 */
public class Solution {
    public String originalDigits(String s) {
        int[] cnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        String[] strings = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        // 这个排列每次去掉一个能够唯一确定的数字
        int[] nums = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};
        StringBuilder stb = new StringBuilder();
        for (int num : nums) {
            int k = Integer.MAX_VALUE;
            char[] chars = strings[num].toCharArray();
            for (char c : chars) {
                k = Math.min(k, cnts[c - 'a']);
            }
            for (char c : chars) {
                cnts[c - 'a'] -= k;
            }
            while (k-- > 0) {
                stb.append(num);
            }
        }
        char[] chars = stb.toString().toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
