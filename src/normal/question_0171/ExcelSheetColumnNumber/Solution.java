package normal.question_0171.ExcelSheetColumnNumber;

import org.junit.jupiter.api.Test;

/**
 * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 * <pre>
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/8/30 22:24
 */
public class Solution {

    @Test
    public void test() {
//        System.out.println('Z' - 'A' + 1);
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("FXSHRXW"));
    }

    public int titleToNumber(String columnTitle) {
        int result = 0;
        int n = columnTitle.length();
        for (int i = 0; i < n; i++) {
            result += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, n - i - 1);
        }
        return result;
    }
}
