package question_0097.InterleavingString;

import org.junit.Test;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * <p>
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 * <p>
 * <pre>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * </pre>
 * <p>
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 * <p>
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * <pre>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * </pre>
 * <p>
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * <p>
 * 提示：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * <pre>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * </pre>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/9/2 23:15
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(isInterleave("dbbcc","aabcc", "aadbbcbccc"));
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        return true;
    }
}
