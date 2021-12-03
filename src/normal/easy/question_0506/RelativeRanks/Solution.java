package normal.easy.question_0506.RelativeRanks;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.
 * <p>
 * The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
 * <pre>
 * The 1st place athlete's rank is "Gold Medal".
 * The 2nd place athlete's rank is "Silver Medal".
 * The 3rd place athlete's rank is "Bronze Medal".
 * For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
 * </pre>
 * Return an array answer of size n where answer[i] is the rank of the ith athlete.
 * <p>
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * <p>
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * <pre>
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * </pre>
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 * <p>
 * <pre>
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/2 22:18
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }


    public String[] findRelativeRanks(int[] score) {
        if (score.length == 1) {
            return new String[]{"Gold Medal"};
        }
        int length = score.length;
        String[] ret = new String[length];
        if (score.length == 2) {
            String a = "Gold Medal";
            String b = "Silver Medal";
            return new String[]{score[0] > score[1] ? a : b, score[0] > score[1] ? a : b};
        }

        int[] arr = new int[length];
        System.arraycopy(score, 0, arr, 0, length);
        Arrays.sort(arr);
        Map<Integer, String> map = new HashMap<>();
        map.put(arr[arr.length - 1], "Gold Medal");
        map.put(arr[arr.length - 2], "Silver Medal");
        map.put(arr[arr.length - 3], "Bronze Medal");

        for (int i = 0; i < arr.length - 3; i++) {
            map.put(arr[i], String.valueOf(length - i));
        }
        for (int i = 0; i < score.length; i++) {
            ret[i] = map.get(score[i]);
        }
        return ret;
    }
}
