package normal.easy.question_1491.AverageSalaryExcludingTheMinimumAndMaximumSalary;

import java.util.Arrays;

/**
 * You are given an array of unique integers salary where salary[i] is the salary of the ith employee.
 * <p>
 * Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/21 22:02
 */
public class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0.0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        return sum / salary.length - 2;
    }
}
