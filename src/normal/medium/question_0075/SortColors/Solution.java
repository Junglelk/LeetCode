package normal.medium.question_0075.SortColors;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/10/30 16:25
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 1, 2, 1, 0, 2, 1, 1, 2, 0, 1, 2, 1, 0};
        sortColorsNoApi(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    public void sortColorsNoApi(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = temp;
                p1++;
            } else if (nums[i] == 0) {
                // 这一步由于 1 的头与 0 的尾紧挨着，所以可能会把 1 换到后面去
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                // 所以要在这里交换回来
                if (p0 < p1) {
                    temp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = temp;
                }
                p0++;
                p1++;
            }
        }
    }

}
