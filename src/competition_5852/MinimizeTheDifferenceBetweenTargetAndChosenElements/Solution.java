package competition_5852.MinimizeTheDifferenceBetweenTargetAndChosenElements;

/**
 * 给你一个大小为 m x n 的整数矩阵 mat 和一个整数 target 。
 * <p>
 * 从矩阵的 每一行 中选择一个整数，你的目标是 最小化 所有选中元素之 和 与目标值 target 的 绝对差 。
 * <p>
 * 返回 最小的绝对差 。
 * <p>
 * a 和 b 两数字的 绝对差 是 a - b 的绝对值。
 * <pre>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
 * 输出：0
 * 解释：一种可能的最优选择方案是：
 * - 第一行选出 1
 * - 第二行选出 5
 * - 第三行选出 7
 * 所选元素的和是 13 ，等于目标值，所以绝对差是 0 。
 * </pre>
 *
 * @author Jungle
 * @since 2021/8/22 10:53
 */
public class Solution {
    /**
     * <h1>背包型动态规划</h1>
     * <h2>思路与算法</h2>
     * <p>
     * 我们用 f[i][j] 表示在矩阵 mat 的第 0, 1,⋯,i 行分别选择一个整数，是否存在一种和为 j 的方案。在进行状态转移时，我们枚举第 i 行的每一个数 x，那么除去第 i 行的和即为 j-x，因此有状态转移方程：
     * <code>f[i][j] ← f[i-1][j-x]</code>
     * <p>
     * 这里的<code>←</code>表示转移方向。由于<code>f[i][j]</code>表示的是「存在性」，因此如果 <code>f[i-1][j-x]</code> 的值为<code>true</code>，那么将<code>f[i][j]</code>更新为<code>true</code>，否则<code>f[i][j]</code>保持不变。换句话说，也就是：
     * <p>
     * <code>f[i][j]=f[i][j]∨f[i−1][j−x]</code>
     * <p>
     * 这里的<code>∨</code>表示逻辑或运算。
     * <p>
     * 在动态规划完成后，我们遍历所有的<code>f[m-1][..]</code>，如果其中的某一项<code>f[m-1][j]</code>的值为<code>true</code>，那么说明存在一种和为<code>j</code>的方案，我们用<code>∣j−target∣</code>更新最终的答案即可。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimize-the-difference-between-target-and-chosen-elements/solution/zui-xiao-hua-mu-biao-zhi-yu-suo-xuan-yua-mlym/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param mat    矩阵
     * @param target 目标值
     * @return 最小的绝对差
     */
    public int minimizeTheDifference(int[][] mat, int target) {

        return 0;
    }
}
