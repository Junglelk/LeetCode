package interview.ch01.question_05.OneAway;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 * <p>
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/1/24 22:09
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(oneEditAway("pale","pala"));
    }



    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        Map<Character, Integer> firstMap = new HashMap<>();
        Map<Character, Integer> secondMap = new HashMap<>();
        char[] chars = first.toCharArray();
        char[] chars1 = second.toCharArray();
        for (char aChar : chars) {
            firstMap.put(aChar, firstMap.getOrDefault(aChar, 0) + 1);
        }
        for (char c : chars1) {
            secondMap.put(c, secondMap.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (Character character : firstMap.keySet()) {
            if (!firstMap.get(character).equals(secondMap.get(character))) {
                count++;
            }
        }
        return count <= 1;
    }
}
