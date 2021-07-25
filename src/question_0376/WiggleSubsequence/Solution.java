package question_0376.WiggleSubsequence;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:
 * <p>
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * <pre>
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * </pre>
 * 子序列可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * <p>
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 * </p>
 * 例如：
 * <pre>
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 * </pre>
 *
 * @author Jungle
 * @since 2021/7/23 18:06
 */
public class Solution {
    @Test
    public void test() {
        // 6
        System.out.println(wiggleMaxLengthS(new int[]{1, 7, 4, 9, 2, 5}));
        // 7
        System.out.println(wiggleMaxLengthS(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        // 4
        System.out.println(wiggleMaxLengthS(new int[]{1, 2, 3, 4, 5, 0, 6, 7, 8, 9}));
        // 2
        System.out.println(wiggleMaxLengthS(new int[]{1, 0}));
        // 1
        System.out.println(wiggleMaxLengthS(new int[]{0, 0, 0}));
        // 202
        System.out.println(wiggleMaxLengthS(new int[]{51, 226, 208, 165, 202, 286, 190, 212, 219, 271, 36, 245, 20, 238, 238, 89, 105, 66, 73, 9, 254, 206, 221, 237, 203, 33, 249, 253, 150, 102, 57, 249, 203, 10, 123, 178, 85, 203, 35, 276, 129, 116, 37, 163, 99, 142, 187, 249, 134, 77, 217, 298, 29, 127, 174, 115, 122, 178, 12, 80, 122, 76, 16, 41, 115, 84, 104, 121, 127, 40, 287, 129, 9, 172, 112, 51, 40, 135, 205, 53, 259, 196, 248, 5, 123, 184, 209, 130, 271, 42, 18, 143, 24, 101, 10, 273, 252, 50, 173, 80, 119, 129, 45, 257, 299, 78, 278, 78, 190, 215, 284, 129, 200, 232, 103, 97, 167, 120, 49, 298, 141, 146, 154, 233, 214, 196, 244, 50, 110, 48, 152, 82, 226, 26, 254, 276, 292, 286, 215, 56, 128, 122, 82, 241, 222, 12, 272, 192, 224, 136, 116, 70, 39, 207, 295, 49, 194, 90, 210, 123, 271, 18, 276, 87, 177, 240, 276, 33, 155, 200, 51, 6, 212, 36, 149, 202, 48, 114, 58, 91, 83, 221, 175, 148, 278, 300, 284, 86, 191, 95, 77, 215, 113, 257, 153, 135, 217, 76, 85, 269, 126, 194, 199, 195, 20, 204, 194, 50, 220, 228, 90, 221, 256, 87, 157, 246, 74, 156, 9, 196, 16, 259, 234, 79, 31, 206, 148, 12, 223, 151, 96, 229, 165, 9, 144, 26, 255, 201, 33, 89, 145, 155, 1, 204, 37, 107, 80, 212, 88, 186, 254, 9, 158, 180, 24, 45, 158, 100, 52, 131, 71, 174, 229, 236, 296, 299, 184, 168, 41, 45, 76, 68, 122, 85, 292, 238, 293, 179, 143, 128, 47, 87, 267, 53, 187, 76, 292, 0, 160, 70, 172, 292, 9, 64, 156, 153, 26, 145, 196, 222}));
    }

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
    public int wiggleMaxLengthS(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1 ;
        int down  = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(up + 1, down);
            }
        }
        return Math.max(up, down);
    }
}
