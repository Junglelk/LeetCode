package normal.medium.question_0423.ReconstructOriginalDigitsFromEnglish;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }

    public String originalDigits(String s) {
        int[] cnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        StringBuilder stb = new StringBuilder();
        for (String num : map.keySet()) {
            int k = Integer.MAX_VALUE;
            char[] chars = num.toCharArray();
            for (char c : chars) {
                k = Math.min(k, cnts[c - 'a']);
            }
            for (char c : chars) {
                cnts[c - 'a'] -= k;
            }
            while (k-- > 0) {
                stb.append(map.get(num));
            }
        }
        char[] chars = stb.toString().toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
