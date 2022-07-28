package normal.easy.question_0020.ValidParentheses;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/valid-parentheses">valid-parentheses</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/5 21:40
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(isValid("()"));
    }


    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        map.put('&', '$');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                stack.push(temp);
                continue;
            }
            char c = stack.isEmpty() ? '&' : stack.pop();
            if (map.get(c) != temp) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
