package normal.easy.question_1154.DayOfTheYear;

import java.util.Arrays;

/**
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
 * <p>
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 * <p>
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/21 20:51
 */
public class Solution {
    public int dayOfYear(String date){
        int[] split = Arrays.stream(date.split("-")).mapToInt(Integer::parseInt).toArray();
        int ans = 0;
        int[] days = new int[]{31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        int point = split[1] - 2;
        if (point >= 0) {
            ans += days[point];
        }
        ans += split[2];
        if ((split[0] % 100 == 0 && split[0] % 400 == 0) || (split[0] % 100 != 0 && split[0] % 4 == 0)) {
            if (split[1] > 2) {
                ans++;
            }
        }
        return ans;
    }
}
