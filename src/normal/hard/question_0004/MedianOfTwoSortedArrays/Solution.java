package normal.hard.question_0004.MedianOfTwoSortedArrays;

import org.junit.jupiter.api.Test;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <pre>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2020/09/07 23:36
 */
class Solution {

    @Test
    public void test() {
        int[] a = {13};
        int[] b = {2, 4, 7, 7};
        System.out.println(findMedianSortedArrays(a, b));
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2])
                num[i++] = nums2[p2++];
            else
                num[i++] = nums1[p1++];
        }
        while (p1 < nums1.length) {
            num[i++] = nums1[p1++];
        }

        while (p2 < nums2.length) {
            num[i++] = nums2[p2++];
        }

        return singleMedianArray(num);
    }

    public double singleMedianArray(int[] num) {
        double result;
        int length = num.length;
        if (length % 2 == 0) {
            result = ((double) num[length / 2] + (double) num[(length / 2) - 1]) / 2;
        } else {
            result = num[length / 2];
        }
        return result;
    }
}