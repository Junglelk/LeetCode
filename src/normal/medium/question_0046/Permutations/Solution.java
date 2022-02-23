package normal.medium.question_0046.Permutations;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <pre>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/23 22:02
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, 0, new ArrayList<Integer>(), used, list);
        return list;
    }

    private void dfs(int[] nums, int n, int depth, List<Integer> temp, boolean[] used, List<List<Integer>> list) {
        if (depth == n) {
            list.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
            }
            used[i] = true;
            dfs(nums, n, depth + 1, temp, used, list);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
