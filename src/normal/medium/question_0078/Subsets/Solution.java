package normal.medium.question_0078.Subsets;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <pre>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/23 22:20
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }


    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[n];
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dfs(nums, 0, i, temp, list);
        }
        return list;
    }

    private void dfs(int[] nums, int i, int k, List<Integer> temp, List<List<Integer>> list) {
        if (k == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            dfs(nums, i + 1, k - 1, temp, list);
            temp.remove(temp.size() - 1);
        }

    }
}
