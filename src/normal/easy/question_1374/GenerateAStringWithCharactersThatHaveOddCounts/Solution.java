package normal.easy.question_1374.GenerateAStringWithCharactersThatHaveOddCounts;

/**
 * Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.
 * <p>
 * The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.  
 *
 * <pre>
 * Input: n = 4
 * Output: "pppz"
 * Explanation: "pppz" is a valid string since the character 'p' occurs three times and the character 'z' occurs once. Note that there are many other valid strings such as "ohhh" and "love".
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts">generate-a-string-with-characters-that-have-odd-counts</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/8/1 13:51
 */
public class Solution {
    public String generateTheString(int n) {
        String str = "qwertyuiopasdfghjklzxcvbnm";
        if (n < 26) {
            return str.substring(0, n);
        }
        char a = 'a';
        StringBuilder stb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                stb.append(a);
            }
            stb.append('b');
        } else {
            for (int i = 0; i < n; i++) {
                stb.append(a);
            }
        }
        return stb.toString();
    }
}
