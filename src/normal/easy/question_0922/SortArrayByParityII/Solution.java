package normal.easy.question_0922.SortArrayByParityII;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * <p>
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * <p>
 * 你可以返回 任何满足上述条件的数组作为答案 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sort-array-by-parity-ii">sort-array-by-parity-ii</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/1 11:21
 */
public class Solution {

    @Test
    public void test() {
        int[] A = {7, 6, 8, 5, 4, 9};
        System.out.println(Arrays.toString(sortArrayByParityII(A)));
    }

    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        int n = A.length;
        int temp = 0;
        int[] A1 = new int[n];
        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 0) {
                A1[even] = A[i];
                even += 2;
            }
            if (A[i] % 2 == 1) {
                A1[odd] = A[i];
                odd += 2;
            }
        }
        return A1;
    }
}
/**
 *
 */