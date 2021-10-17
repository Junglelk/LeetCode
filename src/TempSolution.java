import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jungle
 * @since 2021/10/17 10:29
 */
public class TempSolution {

    @Test
    public void test() {
        System.out.println();
    }


    public int countMaxOrSubsets(int[] nums) {

        int maxNum = 0;
        for (int num : nums) {
            maxNum |= num;
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < nums.length - 1; j++) {
                temp = nums[i] | nums[j];
                if (temp == maxNum) {
                    break;
                }
            }
            result += (int) Math.pow(2, nums.length - i) - 1;
        }

        return result;
    }
}
