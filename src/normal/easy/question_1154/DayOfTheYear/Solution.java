package normal.easy.question_1154.DayOfTheYear;

import org.junit.Test;

import java.text.ParseException;

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

    @Test
    public void test() throws ParseException {
        System.out.println(dayOfYear("2019-01-09"));
    }


    public int dayOfYear(String date) {
        int year = 0;
        int month = 0;
        int day = 0;

        for (int i = 0; i < date.length(); i++) {
            int temp = date.charAt(i) - '0';
            if (i == 0) {
                year += temp * 1000;
            } else if (i == 1) {
                year += temp * 100;
            } else if (i == 2) {
                year += temp * 10;
            } else if (i == 3) {
                year += temp;
            } else if (i == 5) {
                month += temp * 10;
            } else if (i == 6) {
                month += temp;
            } else if (i == 8) {
                day += temp * 10;
            } else if (i == 9) {
                day += temp;
            }
        }

        int ans = 0;
        int[] days = new int[]{31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        if (month >= 2) {
            ans += days[month - 2];
        }
        ans += day;
        if ((year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
            if (month > 2) {
                ans++;
            }
        }
        return ans;
    }
}
