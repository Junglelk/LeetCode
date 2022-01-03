package competition.competition_5863.CountSpecialQuadruplets;

import org.junit.jupiter.api.Test;

/**
 * <pre>
 * 输入：nums = [1,1,1,3,5]
 * 输出：4
 * 解释：满足要求的 4 个四元组如下：
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 * </pre>
 *
 * @author Jungle
 * @since 2021/9/5 10:33
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(countQuadruplets(new int[]{9, 6, 8, 23, 39, 23}));
    }

    public int countQuadruplets(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int result = nums[i] + nums[j] + nums[k];
                    for (int l = k + 1; l < nums.length; l++) {
                        if (result == nums[l]) {
                            num++;
                        }
                    }

                }
            }
        }
        return num;
    }
}
