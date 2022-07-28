package normal.question_0654.SetMismacth;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Jungle
 * @since 2021/7/4 23:28
 */
public class Solution {

    @Test
    public void test() {

    }


    /**
     * 原本的654似乎不是这题，但也找不到这题的出处
     */
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                point = i;
                break;
            }
        }
        int sum = Arrays.stream(nums).sum();
        int origin = ((1 + nums.length) * (nums.length)) / 2;
        int length = origin - sum;
        return new int[]{nums[point], nums[point] + length};
    }
}
