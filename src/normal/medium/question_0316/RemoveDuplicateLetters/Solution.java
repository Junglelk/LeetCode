package normal.medium.question_0316.RemoveDuplicateLetters;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <pre>
 * 输入：s = "bcabc"
 * 输出："abc"
 *  </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/1/18 21:24
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(removeDuplicateLetters("bcabc"));
    }



    /**
     * <pre>
     * 使用栈作为辅助数据结构
     * 记录每一个字符串最后出现的下标
     * 判断当前读到的字符在栈中是否已经出现
     * </pre>
     *
     * @param s 输入字符串
     * @return 输出字符串
     */
    public String removeDuplicateLetters(String s) {
        int[] len = new int[26];
        char[] chars = s.toCharArray();
        // 记录最后出现的下标
        for (int i = 0; i < chars.length; i++) {
            len[chars[i] - 'a'] = i;
        }
        // 是否已经出现
        boolean[] booleans = new boolean[26];

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < chars.length; i++) {
            if (booleans[chars[i] - 'a']) {
                continue;
            }
            // 栈非空，且栈底（即最后一个压入栈的元素）的 ascii 码大于当前元素，且该元素后续后续还会出现
            while (!stack.isEmpty() && stack.peek() > chars[i] && len[stack.peek() - 'a'] > i) {
                Character character = stack.pop();
                booleans[character - 'a'] = false;
            }
            stack.push(chars[i]);
            booleans[chars[i] - 'a'] = true;
        }
        StringBuilder stb = new StringBuilder();
        while (!stack.isEmpty()) {
            stb.append(stack.pop());
        }

        return stb.reverse().toString();
    }
}
