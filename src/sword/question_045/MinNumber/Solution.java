package sword.question_045.MinNumber;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <pre>
 * 输入: [10,2]
 * 输出: "102"
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author mk
 * @since 2022/3/11 9:35
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(minNumber(new int[]{10, 2, 100, 254, 12, 14}));
    }


    public String minNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < numStr.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStr, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder stb = new StringBuilder();
        for (String s : numStr) {
            stb.append(s);
        }
        return stb.toString();
    }
}
