package competition_5853.FindArrayGivenSubsetSums;

/**
 * 存在一个未知数组需要你进行还原，给你一个整数 n 表示该数组的长度。另给你一个数组 sums ，由未知数组中全部 2n 个 子集的和 组成（子集中的元素没有特定的顺序）。
 * <p>
 * 返回一个长度为 n 的数组 ans 表示还原得到的未知数组。如果存在 多种 答案，只需返回其中 任意一个 。
 * <p>
 * 如果可以由数组 arr 删除部分元素（也可能不删除或全删除）得到数组 sub ，那么数组 sub 就是数组 arr 的一个 子集 。sub 的元素之和就是 arr 的一个 子集的和 。一个空数组的元素之和为 0 。
 * <p>
 * 注意：生成的测试用例将保证至少存在一个正确答案。
 * <pre>
 * 输入：n = 3, sums = [-3,-2,-1,0,0,1,2,3]
 * 输出：[1,2,-3]
 * 解释：[1,2,-3] 能够满足给出的子集的和：
 * - []：和是 0
 * - [1]：和是 1
 * - [2]：和是 2
 * - [1,2]：和是 3
 * - [-3]：和是 -3
 * - [1,-3]：和是 -2
 * - [2,-3]：和是 -1
 * - [1,2,-3]：和是 0
 * 注意，[1,2,-3] 的任何排列和 [-1,-2,3] 的任何排列都会被视作正确答案。
 * </pre>
 *
 * @author Jungle
 * @since 2021/8/22 11:47
 */
public class Solution {
    public int[] recoverArray(int n, int[] sums) {
        return null;
    }
}
