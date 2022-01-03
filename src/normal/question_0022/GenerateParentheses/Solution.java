package normal.question_0022.GenerateParentheses;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * <pre>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/24 22:23
 */

public class Solution {

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
    }

    /**
     * 考虑 i = n 时，相比n-1 组括号增加的那一组括号的数量
     * <p>
     * 由于初始条件已知：n = 1 时，组合为 "()"，对于 i = n 的情况，我们考虑括号排列最左侧的括号。
     * <p>
     * 这是个左括号，并能与对应的右括号组合生成一对括号。这就是相比n-1增加进来的括号。则有：
     * <p>
     * i &lt; n 时，n对括号应该为
     * <p>
     * "(" + [i=p时所有的括号的排列组合] + ")" + [i=q] 时所有括号的排列组合
     * <p>
     * 其中 p + q = n-1，即所有p和q的组合都需要遍历
     *
     * @param n 有n对括号
     * @return {@link List}
     */
    public List<String> generateParenthesis(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0)
            return new ArrayList<>();
        List<String> zero = new ArrayList<>();
        zero.add("");
        result.add(zero);
        List<String> first = new ArrayList<>();
        first.add("()");
        result.add(first);
        for (int i = 2; i <= n; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }

            }
            result.add(temp);
        }
        return result.get(n);
    }

}
