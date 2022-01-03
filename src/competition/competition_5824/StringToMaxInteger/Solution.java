package competition.competition_5824.StringToMaxInteger;

import org.junit.jupiter.api.Test;

/**
 * 给你一个字符串 num ，该字符串表示一个大整数。另给你一个长度为 10 且 下标从 0  开始 的整数数组 change ，该数组将 0-9 中的每个数字映射到另一个数字。更规范的说法是，数字 d 映射为数字 change[d] 。
 * <p>
 * 你可以选择 突变  num 的任一子字符串。突变 子字符串意味着将每位数字 num[i] 替换为该数字在 change 中的映射（也就是说，将 num[i] 替换为 change[num[i]]）。
 * <p>
 * 请你找出在对 num 的任一子字符串执行突变操作（也可以不执行）后，可能得到的 最大整数 ，并用字符串表示返回。
 * <p>
 * 子字符串 是字符串中的一个连续序列。
 *
 * <pre>
 * 输入：num = "132", change = [9,8,5,0,3,6,4,2,6,8]
 * 输出："832"
 * 解释：替换子字符串 "1"：
 * - 1 映射为 change[1] = 8 。
 * 因此 "132" 变为 "832" 。
 * "832" 是可以构造的最大整数，所以返回它的字符串表示。
 * </pre>
 * <pre>
 * 输入：num = "021", change = [9,4,3,5,7,2,1,9,0,6]
 * 输出："934"
 * 解释：替换子字符串 "021"：
 * - 0 映射为 change[0] = 9 。
 * - 2 映射为 change[2] = 3 。
 * - 1 映射为 change[1] = 4 。
 * 因此，"021" 变为 "934" 。
 * "934" 是可以构造的最大整数，所以返回它的字符串表示。
 * </pre>
 *
 * @author Jungle
 * @since 2021/7/25 11:00
 */
public class Solution {
    // "021"
    //[9,4,3,5,7,2,1,9,0,6]

    @Test
    public void test() {
        // 832
        System.out.println(maximumNumber("132",new int[]{9,8,5,0,3,6,4,2,6,8}));
        // 934
        System.out.println(maximumNumber("021",new int[]{9,4,3,5,7,2,1,9,0,6}));
        // 339
        System.out.println(maximumNumber("330",new int[]{9,3,6,3,7,3,1,4,5,8}));
        System.out.println(maximumNumber("3341111",new int[]{0,9,2,3,3,2,5,5,5,5}));
        System.out.println(maximumNumber("33411113",new int[]{0,9,2,3,3,2,5,5,5,5}));
    }

    public String maximumNumber(String num, int[] change) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        int end = num.length();
        boolean first = true;
        boolean hasChange = false;
        for (int i = 0; i < num.length(); i++) {
            int temp = num.charAt(i) - 48;
            if (temp < change[temp]) {
                if (first){
                    start = i;
                    first = false;
                }
                result.append(change[temp]);
                hasChange = true;
            }else {
                if (hasChange) {
                    end = i;
                    break;
                }
                result.append(temp);
            }
        }
        String left = num.substring(0, start);
        String right = num.substring(end);

        return "".concat(left).concat(result.toString()).concat(right);
    }
}
