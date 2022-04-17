package normal.easy.question_0167.TwoSumII;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Jungle
 * @since 2021/7/10 10:23
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 7)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1, left = 0;
        while (left <= right) {
            int temp = numbers[left] + numbers[right];
            if (temp == target) {
                return new int[]{left + 1, right + 1};
            } else if (temp < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return null;
    }
}
