package interview.ch01.question_05.OneAway;

import org.junit.jupiter.api.Test;

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
        // "intention"
        //"execution"
        System.out.println(oneEditAway("intention", "execution"));
    }


    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        int count = 0;
        int[] array = new int[26];
        for (int i = 0; i < first.length(); i++) {
            array[first.charAt(i) - 'a']++;
        }
        for (int i = 0; i < second.length(); i++) {
            array[second.charAt(i) - 'a']--;
        }
        for (int i : array) {
            count += i;
        }
        return count <= 1;
    }
}
