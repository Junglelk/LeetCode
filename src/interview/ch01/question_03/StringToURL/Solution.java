package interview.ch01.question_03.StringToURL;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * <p>
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * <p>
 * and that you are given the "true" length of the string.
 * <p>
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/1/4 21:53
 */
public class Solution {
    public String replaceSpaces(String S, int length) {
        return S.substring(0, length).replaceAll(" ", "%20");
    }
}
