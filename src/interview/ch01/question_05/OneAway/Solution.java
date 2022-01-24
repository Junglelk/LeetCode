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
        int lf = first.length(), ls = second.length();
        if (lf > ls) {
            return oneEditAway(second, first);
        }
        if (ls - lf > 1) {
            return false;
        }
        if (lf == ls) {
            int count = 0;
            for (int i = 0; i < lf; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    count += 1;
                }
            }
            return count <= 1;
        }
        int i = 0;
        int ofs = 0;
        while (i < lf) {
            if (first.charAt(i) != second.charAt(i + ofs)) {
                if (++ofs > 1) {
                    return false;
                }
            } else {
                i += 1;
            }
        }
        return true;
    }
}
