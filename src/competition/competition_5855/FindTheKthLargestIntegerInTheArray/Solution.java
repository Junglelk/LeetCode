package competition.competition_5855.FindTheKthLargestIntegerInTheArray;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。
 * <p>
 * 返回 nums 中表示第 k 大整数的字符串。
 * <p>
 * 注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1" 是第三大的整数。
 *
 * <pre>
 * 输入：nums = ["3","6","7","10"], k = 4
 * 输出："3"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["3","6","7","10"]
 * 其中第 4 大整数是 "3"
 * </pre>
 *
 * @author Jungle
 * @since 2021/8/29 11:05
 */
public class Solution {
    @Test
    public void test() {
        // ["623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"]
        //11
        System.out.println(kthLargestNumber(new String[]{"623986800", "3", "887298", "695", "794", "6888794705", "269409", "59930972", "723091307", "726368", "8028385786", "378585"}, 4));
    }

    public String kthLargestNumber(String[] nums, int k) {
        BigInteger[] ints = new BigInteger[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[i] = new BigInteger(nums[i]);
        }
        Arrays.sort(ints);
        return String.valueOf(ints[nums.length - k]);
    }
}
