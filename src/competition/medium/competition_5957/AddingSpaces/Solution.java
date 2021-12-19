package competition.medium.competition_5957.AddingSpaces;

/**
 * You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in the original string where spaces will be added. Each space should be inserted before the character at the given index.
 * <p>
 * For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place spaces before 'Y' and 'C', which are at indices 5 and 9 respectively. Thus, we obtain "Enjoy Your Coffee".
 * Return the modified string after the spaces have been added.
 * <p>
 * 给你一个下标从 0 开始的字符串 s ，以及一个下标从 0 开始的整数数组 spaces 。
 * <p>
 * 数组 spaces 描述原字符串中需要添加空格的下标。每个空格都应该插入到给定索引处的字符值 之前 。
 * <pre>
 * 例如，s = "EnjoyYourCoffee" 且 spaces = [5, 9] ，那么我们需要在 'Y' 和 'C' 之前添加空格，这两个字符分别位于下标 5 和下标 9 。因此，最终得到 "Enjoy Your Coffee" 。
 * </pre>
 * 请你添加空格，并返回修改后的字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/adding-spaces-to-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/19 15:28
 */
public class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder stb = new StringBuilder();
        int point = 0;
        for (int i = 0; i < s.length(); i++) {
            if (point < spaces.length && i == spaces[point]) {
                stb.append(" ");
                point++;
            }
            stb.append(s.charAt(i));
        }
        return stb.toString();
    }
}
