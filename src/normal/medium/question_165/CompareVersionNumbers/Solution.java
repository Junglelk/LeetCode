package normal.medium.question_165.CompareVersionNumbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given two version numbers, version1 and version2, compare them.
 * <p>
 * Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
 * <p>
 * To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
 * <p>
 * Return the following:
 * <pre>
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 * </pre>
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * <p>
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * <p>
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * <p>
 * 返回规则如下：
 * <pre>
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/1/12 21:40
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(compareVersion("1.01", "1"));
    }


    public int compareVersion(String version1, String version2) {
        Integer[] split1 = Arrays.stream(version1.split("\\.")).map(Integer::parseInt).collect(Collectors.toList()).toArray(new Integer[]{});
        Integer[] split2 = Arrays.stream(version2.split("\\.")).map(Integer::parseInt).collect(Collectors.toList()).toArray(new Integer[]{});

        for (int i = 0; i < split1.length || i < split2.length; ++i) {
            int x = 0, y = 0;
            if (i < split1.length) {
                x = split1[i];
            }
            if (i < split2.length) {
                y = split2[i];
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }
}
