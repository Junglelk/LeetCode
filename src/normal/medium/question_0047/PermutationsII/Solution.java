package normal.medium.question_0047.PermutationsII;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <pre>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/24 23:18
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, nums.length, 0, new ArrayList<Integer>(), used, list);
        return list;
    }

    private void dfs(int[] nums, int n, int depth, List<Integer> temp, boolean[] used, List<List<Integer>> list) {
        if (depth == n) {
            list.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            // 与上一题不同的是如何筛选已经选择过的数字，所以需要数组事先有序
            // 这样才能选择出来相邻的已经选择过的数字并将其跳过以达到去重的目的
            if (used[i] || (i > 0 && used[i - 1] && nums[i - 1] == nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            dfs(nums, n, depth + 1, temp, used, list);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
