package normal.easy.question_1822.SignOfTheProductOfAnArray;

/**
 * There is a function signFunc(x) that returns:
 *
 * <li>1 if x is positive.
 * <li>-1 if x is negative.
 * <li>0 if x is equal to 0.
 * <p>
 * You are given an integer array nums. Let product be the product of all values in the array nums.
 * <p>
 * Return signFunc(product).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sign-of-the-product-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/27 22:23
 */
public class Solution {
    public int arraySign(int[] nums) {
        int tag = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                tag = -tag;
            }
        }
        return tag;
    }
}
