package normal.medium.question_0008.StringToInteger;


import static java.lang.Character.isDigit;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 * <p>
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *  
 * <p>
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/1 10:24
 */
public class Solution {
    /**
     * 1. 切除两边的空格
     * 2. 识别第一个字符
     * 若为正负号，返回这之后连续的最大长度的整数
     * 若为数字，返回连续长度的整数
     * 3. 第一个不为数字也不为正负号，则不转换
     * 4. 转换数字的大小有限制
     */
    public int myAtoi(String str) {
        String nums = str.trim();
        if (!nums.equals("")) {
            StringBuffer sb = new StringBuffer();
            String rt = null;
            if (nums.charAt(0) == '+' || nums.charAt(0) == '-') {
                //如果首个为正负号
                sb.append(nums.charAt(0));
                int i = 1;
                while ((i < nums.length()) && isDigit(nums.charAt(i))) {
                    sb.append(nums.charAt(i++));
                }
                rt = sb.toString();
            } else if (isDigit(nums.charAt(0))) {
                sb.append(nums.charAt(0));
                int i = 1;
                while ((i < nums.length()) && isDigit(nums.charAt(i))) {
                    sb.append(nums.charAt(i++));
                }
                rt = sb.toString();
            } else {
                return 0;
            }
            int result = 0;
            try {
                result = Integer.parseInt(rt);
            } catch (Exception e) {
                if (rt.charAt(0) == '+') {
                    result = Integer.MAX_VALUE;
                } else if (isDigit(rt.charAt(0))) {
                    result = Integer.MAX_VALUE;
                } else if (rt.charAt(0) == '-') {
                    result = Integer.MIN_VALUE;
                }
            }
            return result;
        }
        return 0;
    }
}