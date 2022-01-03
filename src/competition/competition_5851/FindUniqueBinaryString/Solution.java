package competition.competition_5851.FindUniqueBinaryString;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，
 * <p>
 * 且每个字符串长度都是 n 。
 * <p>
 * 请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。
 *
 * @author Jungle
 * @since 2021/8/22 10:39
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(findDifferentBinaryString(new String[]{"00","11","01"}));
    }


    public String findDifferentBinaryString(String[] nums) {
        int m = nums[0].length();
        int max = (int) Math.pow(2, m);
        String str = "";
        Set<String> set = new HashSet<>(Arrays.asList(nums));
        for (int i = 0; i < max; i++) {
            str = Integer.toBinaryString(i);
            while (str.length() < m) {
                str = "0" + str;
            }
            if (!set.contains(str)) {
                break;
            }
        }
        return str;
    }
}
