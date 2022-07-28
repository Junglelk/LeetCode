package normal.easy.question_1025.DivisorGame;

/**
 * Description:
 * <p>
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
 * <p>
 * Choosing any x with 0 < x < n and n % x == 0.<br>
 * Replacing the number n on the chalkboard with n - x.<br>
 * Also, if a player cannot make a move, they lose the game.<br>
 * <p>
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 * <p>
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。<br>
 * 用 N - x 替换黑板上的数字 N 。<br>
 * 如果玩家无法执行这些操作，就会输掉游戏。<br>
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/divisor-game">divisor-game</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Jungle
 * @since 2021/8/6 15:52
 */
public class Solution {
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}
