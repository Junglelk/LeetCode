package normal.easy.question_0997.FindTheTownJudge;

/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <pre>
 *  1. The town judge trusts nobody.
 *  2. Everybody (except for the town judge) trusts the town judge.
 *  3. There is exactly one person that satisfies properties 1 and 2.
 * </pre>
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 * 在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
 * <p>
 * 如果小镇的法官真的存在，那么：
 * <pre>
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足条件 1 和条件 2 。
 * </pre>
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-town-judge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/7 21:37
 */
public class Solution {
    /**
     * 一个人信任别人，则信任点数-1；一个人被人信任，信任点数+1；由于所有人都信任法官，而法官不信任任何人，所以法官的信任点数是 n - 1
     *
     * @param n     人数
     * @param trust 信任数组
     * @return 法官
     */
    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        int[] judge = new int[n + 1];

        for (int[] ints : trust) {
            judge[ints[0]]--;
            judge[ints[1]]++;
        }
        for (int i = 0; i < judge.length; i++) {
            if (judge[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
