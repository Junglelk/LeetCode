package normal.easy.question_1688.CountOfMatchesInTournament;

import org.junit.jupiter.api.Test;

/**
 * You are given an integer n, the number of teams in a tournament that has strange rules:
 * <pre>
 * If the current number of teams is even, each team gets paired with another team.
 *      A total of n / 2 matches are played, and n / 2 teams advance to the next round.
 * If the current number of teams is odd, one team randomly advances in the tournament,
 *      and the rest gets paired. A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
 * </pre>
 * Return the number of matches played in the tournament until a winner is decided.
 * <p>
 * 给你一个整数 n ，表示比赛中的队伍数。比赛遵循一种独特的赛制：
 * <pre>
 * 如果当前队伍数是 偶数 ，那么每支队伍都会与另一支队伍配对。总共进行 n / 2 场比赛，且产生 n / 2 支队伍进入下一轮。
 * 如果当前队伍数为 奇数 ，那么将会随机轮空并晋级一支队伍，其余的队伍配对。总共进行 (n - 1) / 2 场比赛，且产生 (n - 1) / 2 + 1 支队伍进入下一轮。
 * </pre>
 * 返回在比赛中进行的配对次数，直到决出获胜队伍为止。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-matches-in-tournament
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/1/25 21:33
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(numberOfMatches(7));
    }

    public int numberOfMatches(int n) {
        // 会有n-1个队伍无法晋级比赛，淘汰掉 n-1 个队伍需要 n-1 场比赛
        return n - 1;
    }
}
