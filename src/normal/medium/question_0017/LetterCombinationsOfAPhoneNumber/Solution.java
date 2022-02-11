package normal.medium.question_0017.LetterCombinationsOfAPhoneNumber;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/2/11 22:41
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(letterCombinations("254"));
    }


    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    /**
     * 递归子问题：除当前元素外，其余元素的解，显然，“无其余元素”就是终止条件
     *
     * @param combinations 结果列表
     * @param phoneMap     号码和字符串对照
     * @param digits       数字字符串
     * @param index        索引
     * @param combination  组合字符串
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        // 无其余元素
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            // 获取到当前索引的字符
            char digit = digits.charAt(index);
            // 得到数字对应的字符串
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            // 遍历字符串，并将遍历到的字符加入到上一个索引处的字符串内
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                // 当前元素组合其余元素，仅组合一个进来
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 由于最后一个元素有多个，所以每次都需要恢复到未组合的状态
                combination.deleteCharAt(index);
            }
        }
    }
}
