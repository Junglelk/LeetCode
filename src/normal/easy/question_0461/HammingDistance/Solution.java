package normal.easy.question_0461.HammingDistance;

/**
 * The <a href="https://en.wikipedia.org/wiki/Hamming_distance">Hamming distance</a> between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, return the Hamming distance between them.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/hamming-distance">Hamming distance</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        char[] chars = Integer.toBinaryString(i).toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
