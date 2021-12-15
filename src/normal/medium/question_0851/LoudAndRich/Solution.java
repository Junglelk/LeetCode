package normal.medium.question_0851.LoudAndRich;

import org.junit.Test;

import java.util.*;

/**
 * There is a group of n people labeled from 0 to n - 1 where each person has a different amount of money and a different level of quietness.
 * <p>
 * You are given an array richer where richer[i] = [ai, bi] indicates that ai has more money than bi and an integer array quiet where quiet[i] is the quietness of the ith person. All the given data in richer are logically correct (i.e., the data will not lead you to a situation where x is richer than y and y is richer than x at the same time).
 * <p>
 * Return an integer array answer where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of quiet[y]) among all people who definitely have equal to or more money than the person x.
 * <p>
 * 有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为 x 的人简称为 "person x "。
 * <p>
 * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组 quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
 * <p>
 * 现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
 * <p>
 * <pre>
 * 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * 输出：[5,5,2,5,4,5,6,7]
 * 解释：
 * answer[0] = 5，
 * person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
 * 唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
 * 但是目前还不清楚他是否比 person 0 更有钱。
 * answer[7] = 7，
 * 在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
 * 最安静（有较低安静值 quiet[x]）的人是 person 7。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/loud-and-rich
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/15 21:08
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(Arrays.toString(loudAndRich(new int[][]{{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}}, new int[]{3, 2, 5, 4, 6, 1, 7, 0})));
    }


    /**
     * 拓扑排序：<br>
     * 在有向图中选一个无前驱的节点并输出它；<br>
     * 从途中删除该点和所有与它有关的弧；<br>
     * 重复上述步骤；<br>
     * 若输出的节点数小于图的顶点数，说明存在环，否则输出序列就是一个拓扑序列。<br>
     *
     * @param richer 有钱人数组
     * @param quiet  安静数组
     * @return 结果数组
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(null);
        }
        int[] nums = new int[n];
        for (int[] node : richer) {
            nodes.set(node[0], new ArrayList<>() {{add(node[1]);}});
            nums[node[1]]++;
        }

        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i;
        }
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                deque.offer(i);
            }
        }

        while (!deque.isEmpty()) {
            int x = deque.poll();
            for (Integer y : nodes.get(x)) {
                if (quiet[ans[x]] < quiet[ans[y]]) {
                    ans[y] = ans[x];
                }
                if (--nums[y] <= 0) {
                    deque.offer(y);
                }
            }
        }
        return ans;
    }
}
