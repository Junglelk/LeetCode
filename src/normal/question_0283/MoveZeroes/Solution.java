package normal.question_0283.MoveZeroes;

/**
 * @author Jungle
 * @since 2021/10/6 21:58
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        boolean exch = true;
        int times = 0;
        while (exch) {
            exch = false;
            int temp;
            times++;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0) {
                    temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    exch = true;
                }
            }
            if (times > nums.length)
                break;
        }
    }
}
