package normal.medium.question_0797.AllPathsFromSourceToTarget;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * <p>
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * <p>
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * <pre>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/11 10:05
 */
public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        temp.add(0);
        dfs(graph, ans, graph[0], temp, 0);
        return ans;
    }

    private void dfs(int[][] graph, List<List<Integer>> ans, int[] ints, List<Integer> temp, int i) {
        if (i == graph.length - 1) {
            ans.add(new LinkedList<>(temp));
            return;
        }
        for (int j : ints) {
            temp.add(j);
            dfs(graph, ans, graph[j], temp, j);
            temp.remove(temp.size() - 1);
        }
    }
}
