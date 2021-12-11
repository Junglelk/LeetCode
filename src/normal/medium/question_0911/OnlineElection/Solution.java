package normal.medium.question_0911.OnlineElection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given two integer arrays persons and times. In an election, the ith vote was cast for persons[i] at time times[i].
 * <p>
 * For each query at a time t, find the person that was leading the election at time t. Votes cast at time t will count towards our query. In the case of a tie, the most recent vote (among tied candidates) wins.
 * <p>
 * Implement the TopVotedCandidate class:
 * <pre>
 * TopVotedCandidate(int[] persons, int[] times) Initializes the object with the persons and times arrays.
 * int q(int t) Returns the number of the person that was leading the election at time t according to the mentioned rules.
 * </pre>
 * 给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。
 * <p>
 * 对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。
 * <p>
 * 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 * <p>
 * 实现 TopVotedCandidate 类：
 * <pre>
 * TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
 * int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/online-election
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/11 16:59
 */
public class Solution {
}

class TopVotedCandidate {
    List<int[]> list = new ArrayList<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        int val = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (map.get(persons[i]) >= val) {
                val = map.get(persons[i]);
                list.add(new int[]{times[i], persons[i]});
            }
        }
    }

    public int q(int t) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid)[0] <= t) l = mid;
            else r = mid - 1;
        }
        return list.get(r)[0] <= t ? list.get(r)[1] : 0;
    }
}