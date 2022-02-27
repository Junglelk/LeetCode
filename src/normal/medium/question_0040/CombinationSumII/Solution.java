package normal.medium.question_0040.CombinationSumII;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。 
 * <pre>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/27 18:52
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(combinationSum2(new int[]{1}, 8));
    }


    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, temp);
        return list;
    }

    private void dfs(int[] candidates, int target, int cur, List<Integer> temp) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (cur < i && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                // 初解的cur传递到下面，导致了已经遍历过的数字对遍历顺序产生了影响，出现了重复的情况
                dfs(candidates, target - candidates[i], i + 1, temp);
                temp.remove(temp.size() - 1);
            } else {
                break;
            }
        }
    }
}
