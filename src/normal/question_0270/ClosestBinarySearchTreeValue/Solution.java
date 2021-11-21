package normal.question_0270.ClosestBinarySearchTreeValue;

import org.junit.Test;
import other.TreeNode;

/**
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closest-binary-search-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/7/10 14:11
 */
public class Solution {

    @Test
    public void test() {
        //[9,7,12,6,8,11,13]
        TreeNode root = new TreeNode(9,
                new TreeNode(7,
                        new TreeNode(6), new TreeNode(8)),
                new TreeNode(12,
                        new TreeNode(11), new TreeNode(13)));

        System.out.println(closestValue(root, 11.7));
    }


    public int closestValue(TreeNode root, double target) {
        int targetNum = (int) (target + 0.5);
        int temp = root.val;
        int closet = temp < 0 ? temp * -1 : temp;
        while (root != null) {
            int temp1 = (root.val - targetNum) < 0 ? (root.val - targetNum) * -1 : (root.val - targetNum);
            int close = (closet - targetNum) < 0 ? (closet - targetNum) * -1 : (closet - targetNum);
            closet = temp1 < close ? root.val : closet;
            root = root.val > targetNum ? root.left : root.right;
        }
        return closet;
    }
}



