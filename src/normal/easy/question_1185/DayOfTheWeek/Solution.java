package normal.easy.question_1185.DayOfTheWeek;

import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Given a date, return the corresponding day of the week for that date.
 * <p>
 * The input is given as three integers representing the day, month and year respectively.
 * <p>
 * Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 * <p>
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * <p>
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * <p>
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * <pre>
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-week
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/1/3 10:45
 */
public class Solution {
    @Test
    public void test() throws ParseException {
//        System.out.println(dayOfTheWeek(31, 8, 2021));
        System.out.println(dayOfTheWeek(3, 1, 2022));
    }


    public String dayOfTheWeek(int day, int month, int year) throws ParseException {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        return days[i - 1];
    }
}
