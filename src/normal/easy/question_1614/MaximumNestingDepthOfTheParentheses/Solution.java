package normal.easy.question_1614.MaximumNestingDepthOfTheParentheses;

/**
 * A string is a valid parentheses string (denoted VPS) if it meets one of the following:
 * <pre>
 * It is an empty string "", or a single character not equal to "(" or ")",
 * It can be written as AB (A concatenated with B), where A and B are VPS's, or
 * It can be written as (A), where A is a VPS.
 * </pre>
 * We can similarly define the nesting depth depth(S) of any VPS S as follows:
 * <pre>
 * depth("") = 0
 * depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
 * depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
 * depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
 * </pre>>
 * For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
 * <p>
 * Given a VPS represented as string s, return the nesting depth of s.
 * <p>
 * 如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
 * <pre>
 * 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
 * 字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
 * 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
 * </pre>>
 * 类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：
 * <pre>
 * depth("") = 0
 * depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
 * depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
 * depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
 * </pre>
 * 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
 * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/1/7 22:19
 */
public class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
