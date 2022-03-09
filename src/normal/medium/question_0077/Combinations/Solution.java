package normal.medium.question_0077.Combinations;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * <p>
 * You may return the answer in any order.
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <pre>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * </pre>
 * 你可以按 任何顺序 返回答案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/9 22:24
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(combine(10, 1));
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(1, ans, temp, n, k);
        return ans;
    }

    private void dfs(int start, List<List<Integer>> ans, List<Integer> temp, int n, int k) {
        if (temp.size() + (n - start + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(start);
        // 考虑当前值
        dfs(start + 1, ans, temp, n, k);
        temp.remove(temp.size() - 1);
        // 不考虑当前值
        dfs(start + 1, ans, temp, n, k);
    }
}
