package competition_5832.ArrayWithElementsNotEqualToAverageOfNeighbors;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个 下标从 0 开始 的数组 nums ，数组由若干 互不相同的 整数组成。
 * <p>
 * 你打算重新排列数组中的元素以满足：重排后，数组中的每个元素都 不等于 其两侧相邻元素的 平均值 。
 * <p>
 * 更公式化的说法是，重新排列的数组应当满足这一属性：
 * <p>
 * 对于范围 1 <= i < nums.length - 1 中的每个 i ，(nums[i-1] + nums[i+1]) / 2
 * <p>
 * 不等于 nums[i] 均成立 。
 * <p>
 * 返回满足题意的任一重排结果。
 *
 * @author Jungle
 * @since 2021/8/15 10:37
 */
public class Solution {

    @Test
    public void test() {
        int[] ans = rearrangeArray(new int[]{1, 2, 3});
//        int[] ans = rearrangeArray(new int[]{6,2,0,9,7});
        System.out.println(Arrays.toString(ans));

    }

    /**
     * 怀疑这题可以用二叉树解决，根节点大于左子结点小于右子结点，
     * <p>
     * 遍历时，不会出现连续的情况，但目前对二叉树不熟悉，待后续练习。
     *
     * @param nums 待处理数组
     * @return 返回数组
     */

    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        int j = 0;
        int times = nums.length / 2;
        if (times % 2 == 0) {
            times += 1;
        }
        if (nums.length == 3) {
            times = 2;
        }
        for (int i = 0; i < times; i++) {
            for (int k = i; k < nums.length; k += times) {
                ans[j++] = nums[k];
            }
        }
        return ans;
    }
}
