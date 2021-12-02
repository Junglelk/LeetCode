package normal.question_0035.SearchInsertPosition;

import org.junit.Test;

/**
 * @author Jungle
 * @since 2021/7/8 22:03
 */
public class SolutionTest {

    @Test
    public void test() {

    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1, ans = n;
        while (low <= high) {
            int middle = ((-low + high) >> 1) + low;
            if (target <= nums[middle]) {
                ans = middle;
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return ans;
    }


}