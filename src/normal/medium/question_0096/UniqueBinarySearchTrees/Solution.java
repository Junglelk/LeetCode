package normal.medium.question_0096.UniqueBinarySearchTrees;

/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 * <p>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/1 21:02
 */
public class Solution {

    public int numTrees(int n) {
        int[] r = new int[n + 1];
        r[0] = 1;
        r[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 长度为 i 时的1~i的所有节点左右子树的乘积即为 r[i]
                r[i] += r[j - 1] * r[i - j];
            }
        }
        return r[n];
    }
}
