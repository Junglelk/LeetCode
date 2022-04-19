package normal.easy.question_0821.ShortestDistanceToACharacter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.
 * <p>
 * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
 * <p>
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * <p>
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * <p>
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数
 * <pre>
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/shortest-distance-to-a-character">https://leetcode-cn.com/problems/shortest-distance-to-a-character</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/4/19 22:51
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(Arrays.toString(shortestToChar("gsdffglgfdgfgfgfdgfdsgdsfofdgfvegsdjfkghskrhgsuiorweuiohwnjzanvajdvknafragheiqweiuqirghnjkangfvhjdblfhauoihydfuirofhbgrnhufygdfiulkafnadjoqhuqweighrrqyuigjnagfygbflkhgdhguirghbrwuhejjanajkgnavnfkgjhbailkjngdafbjndjshfkdaduifjnauifuifyutfasdsutyyvdsjhvcmknvfdiujhdsfauygrwedhjfdskjvbokjcijhfvdjnvbcxjhsdfzahbndsafmknfvdsjklksdafklsdfvcnmfvbjhjhbdsfvledsesdtfcogdfgfeffsdgsdgsdfgsdgsdf"
                , 'e')));
//        System.out.println(Arrays.toString(shortestToChar("aaaa", 'a')));
    }


    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (ans[j] == 0 && ans[i] != 0) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (ans[j] == 0 && ans[i] != 0) {
                    ans[i] = Math.min(i - j, ans[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
