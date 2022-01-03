package normal.question_1064.FixedPoint;

import org.junit.jupiter.api.Test;

/**
 * 1064: 不动点
 * Given an array of distinct integers arr, where arr is sorted in ascending order, return the smallest index i that satisfies arr[i] == i. If there is no such index, return -1.
 * 给定已经按 升序 排列、由不同整数组成的数组 arr，返回满足 arr[i] == i 的最小索引 i。如果不存在这样的 i，返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fixed-point
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/10 15:15
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(fixedPoint(new int[]{-10,-5,3,4,7,9}));
    }

    public int fixedPoint(int[] arr) {
        int right = arr.length, left = 0;
        while (left <= right) {
            int middle = (right + left) >> 1;
            if (middle > arr[middle]) {
                left = middle + 1;
            }else if(middle < arr[middle])  {
                right = middle - 1;
            }else{
                return middle;
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            if (i == arr[i]) {
//                return i;
//            }
//        }
        return -1;
    }
}
