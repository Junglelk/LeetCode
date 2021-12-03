package normal.medium.question_1249.MinimumRemoveToMakeValidParentheses;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <pre>
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * </pre>
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * <p>
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * <p>
 * 请返回任意一个合法字符串。
 * <p>
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 * <pre>
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 * </pre>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/3 21:10
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(minRemoveToMakeValid("lee(t)(((((((((((((((((((((((((((((((c(o()d))e"));
    }

    public String minRemoveToMakeValid(String s) {
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> remove = new LinkedList<>();
        StringBuilder stb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            }
            if (c == ')') {
                if (left.isEmpty()) {
                    remove.add(i);
                } else {
                    left.pop();
                }
            }
        }
        remove.addAll(left);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (remove.contains(i)) {
                continue;
            }
            stb.append(c);
        }
        return stb.toString();
    }
}
